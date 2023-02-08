from flask import Flask
from flask import request
from flask import render_template


app = Flask(__name__)


text:str
region:str
file:object

model_jr:object
model_gw:object
model_cc:object
model_gs:object
model_jj:object

region_class = ['전라도', '강원도', '충청도', '경상도', '제주도']
# model_class = [model_jr, model_gw, model_cc, model_gs, model_jj]

# def model_select(region):
#     model = model_class[region_class.index(region)]
#     return model


@app.route('/')
def home_page():
    return render_template('index.html')


@app.route('/result', methods=['GET'])
def result():
    
    global text
    global region
    global file
    # global model
    
    region = request.args.get('region')
    text = request.args.get('text')
    file = request.args.get('file')
    # result = model_select(region).predict(txt)
    # result -> wav 파일
    
    from satoori import test
    
    cleaned_text = test.cleaner(text)
    sequence = test.text_to_sqe(cleaned_text)
    wav_file = test.wav_save(sequence)
    
    result = os.path(wav_file)
    
    
    return render_template('result.html', audiofile=result)


app.run(host = 'localhost', port = 5002)