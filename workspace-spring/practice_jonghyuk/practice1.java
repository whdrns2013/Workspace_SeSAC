public class practice1 {
    
    @SpringBootApplication
    public void main (String args[]) {

        String a = "abcde";
        System.out.println(a.indexOf("d"));
        System.out.println(a.indexOf("h"));


        ApplicationContext context2 = new ClassPathXmlApplicationContext("classpath:bean2.xml");
		int i = (int) context2.getBean("bean2");
		System.out.println("bean 생성2 : " + i);
        

    }
}
