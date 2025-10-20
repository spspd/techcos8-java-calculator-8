package calculator;


import java.util.ArrayList;

public class Application {
    public static String a ;
    public static ArrayList<String> list = new ArrayList<String>();
    static int check(int i){
        // input c 
        char c = a.charAt(i);

        if( c <= '9' && c >= '0'){
            return 0; // integer
        }
        int k = check_sentence(i);
        if(k>0){
            return k; // operator
        }
        return -1;
    }
    static int check_sentence(int i){
        // 리스트의 모든 단어에 대해서 확인
        // 일치하는게 여러개라면 바로 뒤에 "숫자가 올 수있는지" 와 "가장 긴것"을 기준으로
        ArrayList<String> able = new ArrayList<String>();
        

        int max_length = a.length();
        for(int it = 0; it < list.size(); it++){
            String target = list.get(it);
            int target_length = target.length();
            for(int j = 0; j< target_length; j++){
                
                if(i >= max_length  ){
                    // 끝이 아님 확인
                    break;
                }

                if(i+j > max_length-1){
                    break;
                }

                if(a.charAt(i+j) != target.charAt(j)){
                    break;
                }

                if(j == target_length-1){
                    if (!(a.charAt(i+j+1) <= '9' && a.charAt(i+j+1) >= '0')){
                        // 뒤에 있는것은 확인했으니 숫자인지 확인
                        break;
                    }
                    able.add(target);
                }
            }

        }
        int max = 0;
        for (int j =0; j < able.size(); j++){
            if(max < able.get(j).length()){
                max = able.get(j).length();
            }
        }
        if(able.size() >0){
            return max;
        }
        else{
            return -1;
        }
    }
    
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        a = camp.nextstep.edu.missionutils.Console.readLine();

        // set
        list.add(",");
        list.add(":");
        list.add(",,");
        // Operater ,
        StringBuffer front_block = new StringBuffer();
        int sum = 0;
        int start = 0;
        try{
        if(a.charAt(0) == '/' && a.charAt(1) == '/'){
            for(int i = 2; i < a.length()-1; i++){
                if(a.charAt(i) == '\\' && a.charAt(i+1) == 'n'){
                    start = i+2;
                    break;
                }else{
                    front_block.append(a.charAt(i));
                }
            }

            if(start == 0){
                throw new IllegalArgumentException();
                // eol 안닫힘 
            }
            else{
                list.add(front_block.toString());
                front_block.setLength(0);
            }
        }

        
        for(int i = start; i < a.length()+1; i++){

            // last 
            if(i == a.length()){
                if(check(i-1) != 0 ){
                    throw new IllegalArgumentException();
                }
                else{
                    sum = sum + Integer.parseInt(front_block.toString());
                    front_block.setLength(0);
                }
                break;
            }


            int result = check(i);
            
            // System.err.println("check : " + result);
            if(result > 0){ // "문자 처리방법"
                if(front_block.length() > 0){
                    sum = sum + Integer.parseInt(front_block.toString());
                    front_block.setLength(0);
                    i = i + result -1;
                }
                else{
                    // System.out.println("test error");
                    throw new IllegalArgumentException();

                }
            }
            else if(result == 0){
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
        System.out.println(e.toString());

    }
    

    }
}
