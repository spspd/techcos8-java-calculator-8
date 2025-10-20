package calculator;

import static org.mockito.ArgumentMatchers.isA;

import java.util.ArrayList;

public class Application {
    public static String a ;
    public static ArrayList<String> list = new ArrayList<String>();
    static int check(int i){
        // input c 
        char c = a.charAt(i);

        if( c <= '9' && c >= '0'){
            return 1; // integer
        }
        else if(check_sentence(i)){
            return 2; // operator
        }
        return -1;
    }
    static boolean check_sentence(int i){
        // 리스트의 모든 단어에 대해서 확인
        // 일치하는게 여러개라면 바로 뒤에 "숫자가 올 수있는지" 와 "가장 긴것"을 기준으로
        ArrayList<String> able = new ArrayList<String>();
        

        int max_length = a.length();
        for(int it = 0; it < list.size(); it++){
            String target = list.get(it);
            int target_length = target.length();
            for(int j = 0; j< target_length; j++){
                if(i+j > max_length-1){
                    break;
                }
                if(a.charAt(i+j) != target.charAt(j)){
                    break;
                }
                if(j == target_length-1){
                    // 여기에다가 뒤에 숫자가 오도록 +
                    able.add(target);
                }
            }
        }

        return false;
    }
    
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        a = camp.nextstep.edu.missionutils.Console.readLine();

        // set
        list.add(",");
        list.add(":");
        // Operater ,
        StringBuffer front_block = new StringBuffer();
        int sum = 0;
        try{
        for(int i = 0; i < a.length()+1; i++){

            // last 
            if(i == a.length()){
                if(check(a.charAt(i-1)) != 1 ){
                    throw new IllegalArgumentException();
                }
                else{
                    sum = sum + Integer.parseInt(front_block.toString());
                    front_block.setLength(0);
                }
                break;
            }


            int result = check(a.charAt(i));
            if(result == 2){ // "문자 처리방법"
                sum = sum + Integer.parseInt(front_block.toString());
                front_block.setLength(0);
            }
            else if(result == 1){
                front_block.append(a.charAt(i));
            }
            else {
                
                throw new IllegalArgumentException();
            }
        }
        // 남은 값 처리
        

        // output
        System.out.println("결과 : " + sum);
    }
    catch(IllegalArgumentException e){
        // error 처리
        System.err.println(e.toString());

    }
    

    }
}
