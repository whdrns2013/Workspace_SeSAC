import os, re, json
import numpy as np
import pandas as pd
from tqdm import tqdm
from konlpy.tag import Okt

FILTERS = "([~.,!?\"':;)(])"
PAD = "<PAD>" # 패딩 토큰. pad
STD = "<SOS>" # 시작 토큰. start of sequence 문장의 시작을 알리는
END = "<END>" # 종료 토큰. end 문장의 끝을 알리는, 문장으로 따지면 마침표
UNK = "<UNK>" # unknown. 사전에 없는 단어. 모르겠는 단어. oov( out of vacab) 과 비슷하게 봐야할 듯

PAD_INDEX = 0
STD_INDEX = 1
END_INDEX = 2
UNK_INDEX = 3

MARKER = [PAD, STD, END, UNK] # 예약어 설정 (실제 예약어는 아니나, 사용자가 예약어로 생각하는.)
CHANGE_FILTER = re.complie(FILTERS)

MAX_SEQUENCE = 25 # 최대 25개 단어까지만 사용하겠다.


def load_data(path):
    data_df = pd.read_csv(path, header=0) # header = 0 : 제목행 불러오지 않기
    question, answer = list(data_df['Q']), list(data_df['A'])
    return question, answer


# 단어 토크나이징 : 띄어쓰기
# (1) 특수문자 빼기
# (2) 띄어쓰기 기준으로 분리
def data_tokenizer(data):
    words = []
    for sent in data:
        sent = re.sub(CHANGE_FILTER, "", sent)
        for word in sent.split():
            words.append(word)
    return [word for word in words if word]


# 형태소 분석
def prepro_like_morphlized(data):
    morph_analyzer = Okt()
    result_data = list()
    for seq in tqdm(data):
        morphlized_seq = ' '.join(morph_analyzer.morphs(seq.replace(' ','')))
        result_data.append(morplized_seq)
    return result_data


# 단어사전 불러오기
def load_vocabulary(path, vocab_path, tokenize_as_morph=False):
    vocabulary_list = []
    if not os.path.exists(vocab_path): # 단어장이 없으면 만들기
        if(os.path.exists(path)):
            data_df = pd.read_csv(path, encoding='utf-8')
            question, answer = load_data(path)
            if tokenize_as_morph:
                qustion, answer = prepro_list_morphlized(question), prepro_list_morphlized(answer)
                
            data = []
            data.extend(question)
            data.extend(answer)
            
            words = data_tokenizer(data) # 토크니이징(띄어쓰기)된 단어들 담기
            words = list(set(words)) # 중복 없애기
            words[:0] = MARKER # 앞에 마커를 붙여주기 eg. a = [1, 2, 3] b = [4, 5, 6] //  b[:0] = a // b == [1, 2, 3, 4, 5, 6]
            
        with open(vocab_path, 'w', encoding='utf-8') as vf:
            for word in words:
                vf.write(word + '\n') # 기록
        
    with open(vocab_path, 'r', encoding = 'utf-8') as vocabulary_file:
        for line in vocabulary_file:
            vocabulary_list.append(line.strip()) # 줄바꿈을 제거하면서 단어만 빼오기
    
    word2idx, idx2word = make_vocabulary(vocabulary_list)
    
    return word2idx, idx2word, len(word2idx)
                  

# 단어 사전 만들기 (2개)
# 하나는 키가 단어, 값이 인덱스. 다른 하나는 키가 인덱스, 값이 단어.
def make_vocabulary(vocabulary_list):
    word2idx = {word : idx for idx, word in enumerate(vocabulary_list)}
    idx2word = {idx : word for idx, word in enumerate(vocabulary_list)}
    return word2idx, idx2word

word2idx, idx2word, vocab_size = load_vocabulary(PATH, VOCAB_PATH)
                  
            
# 인코더 전처리
def enc_processing(value, dictionary, tokenize_as_morph = False):
    sequences_input_index = []
    sequence_length = []
    
    if tokenize_as_morph:
        value = prepro_like_morphlized(value)
        
    for sequence in value:
        sequence = re.sub(CHANGE_FILTER, "", sequence)
        sequence_index = []
        for word in sequence.split():
            if dictionary.get(word) is not None:
                sequence_index.extend([dictionary[word]]) # 괄호 두 개인 이유 : 차원 맞추기
            else:
                sequence_index.extend([dictionary[UNK]]) # 과롷 두 개인 이유 : 차원 맞추기
        
        if len(sequences_index) > MAX_SEQUENCE:
            sequences_index = sequences_index[:MAX_SEQUENCE]
            
        sequences_length.append(len(sequence_index))
        sequence_index += (MAX_SEQUENCE - len(sequence_index)) * [dictionary[PAD]] # 패딩 (최대길이 맞춰 패딩????)
        
        sequences_input_index.append(sequence_index)
        
    return np.asarray(sequences_input_index), sequences_length