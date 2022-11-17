import java.util.Scanner;

public class CodeUp100 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
      
        System.out.print("hello");    //1001

        System.out.print("Hello World");    //1002
        
        System.out.print("Hello\nWorld");    //1003
        
        System.out.print("\'Hello\'");    //1004
        
        System.out.print("\"Hello World\"");    //1005
        
        System.out.print("\"!@#$%^&*()\"");    //1006
        
        System.out.print("\"C:\\Download\\hello.cpp\"");    //1007
        
        System.out.print("\u250c\u252c\u2510\n\u251c\u253c\u2524\n\u2514\u2534\u2518");    //1008

        int n = sc.nextInt();
        System.out.println(n);    //1010

        char ch = sc.next().charAt(0);
        System.out.println(ch);    //1011

        float x = sc.nextFloat();
        System.out.format("%f", x);    //1012 System.out.format 메소드도 printf와 똑같은 기능 제공
        
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.print(a+" "+b);    //1013

        char y = sc.next().charAt(0);
        char z = sc.next().charAt(0);
        System.out.print(z+" "+y);    //1014

        float w = sc.nextFloat();
        System.out.printf("%.2f",w);    //1015 print는 괄호안 내용을 단순히 출력, printf는 C언어의 printf와 동일. %f %s 등을 쓰기위해 사용 
        
        int c = sc.nextInt();        
        System.out.print(c+" "+c+" "+c);    //1017
        
        String m = sc.next();
        System.out.print(m);    //1018
        
        String p = sc.next();
        String[] t = p.split("\\.");
        int t0 = Integer.parseInt(t[0]);
        int t1 = Integer.parseInt(t[1]);
        int t2 = Integer.parseInt(t[2]);
        System.out.printf("%04d.%02d.%02d", t0,t1,t2);    //1019 정규식 \\. (.은 임의의 한 문자를 의미, \은 escape \뒤에 오는 문자를 일반문자로 취급, \. 정규식에서 일반문자 마침표를 의미 )
        
        String i = sc.next();
        String[] u = i.split("-");
        System.out.println(u[0]+u[1]);    //1020

        String str = sc.next();
        System.out.println(str);    //1021
        
        String str2 = sc.nextLine();
        System.out.println(str2);    //1022
        
        String l = sc.next();
        String o[] = l.split("[.]");
        System.out.println(o[0]);
        System.out.println(o[1]);    //1023

        String str_1024 = sc.nextLine();
        for(int i_1024=0; i_1024<str_1024.length(); i_1024++){
            System.out.println("\'"+str_1024.charAt(i_1024)+"\'");
        }    //1024
        
        int i_1025 = sc.nextInt();
        System.out.println((i_1025/10000)*10000);
        System.out.println((i_1025/10000)*10000);  
        //1025
        
        sc.close();
    }

}