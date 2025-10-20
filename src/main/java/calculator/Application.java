package calculator;

public class Application {

    static int check(char c){
        // input c 
        if( c <= '9' && c >= '0'){
            return 1; // integer
        }
        else if(c == ',' || c == ':'){
            return 2; // operator
        }
        return -1;
    }
    public static void main(String[] args) {

        // TODO: 프로그램 구현
        System.out.println("덧셈할 문자열을 입력해 주세요.");
        String a = camp.nextstep.edu.missionutils.Console.readLine();


        // Operater ,
        StringBuffer front_block = new StringBuffer();
        int sum = 0;
        for(int i = 0; i < a.length()+1; i++){

            // last 
            if(i == a.length()){
                if(check(a.charAt(i-1)) != 1 ){
                    // Error throw
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
                break; // Error throw
            }
        }
        // 남은 값 처리
        

        // output
        System.out.println("결과 : " + sum);

    }
}
