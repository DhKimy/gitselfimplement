import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    /*
    루트 A
    wiken.io/ken/8069, 7단계까지 구현
    TDD x
    컨트롤러, 서비스, 리포지터리 모듈화 x
    파일영속성 x
    종료, 등록, 목록, 삭제, 수정 까지 구현
    구글 검색 가능
    Rq 클래스 복붙 가능
    위 조건에서 1시간 30분안에 구현이 가능하다면 클리어
     */
    /*
    == 명언 SSG ==
    명령) 등록
    명언 : 현재를 사랑하라.
    작가 : 작자미상
    1번 명언이 등록되었습니다.
    명령) 등록
    명언 : 현재를 사랑하라.
    작가 : 작자미상
    2번 명언이 등록되었습니다.
    명령) 목록
    번호 / 작가 / 명언
    ----------------------
    2 / 작자미상 / 과거에 집착하지 마라.
    1 / 작자미상 / 현재를 사랑하라.
    명령) 삭제?id=1
    1번 명언이 삭제되었습니다.
    명령) 삭제?id=1
    1번 명언은 존재하지 않습니다.
    명령) 종료
     */
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("=== 명언 SSG ===");

        int number = 0;

        List<String[]> AllList = new ArrayList<>();

        outer:
        while(true){
            String cmd;

            String[] cmdSet = new String[2];

            System.out.print("명령 : ");
            cmd = sc.nextLine();
            cmdSet = cmd.split("\\?", 2);
            cmd = cmdSet[0];
            String content;
            String author;
            String[] maximSet = new String[3];



            switch (cmd){
                case "등록":
                    System.out.print("명언 : ");
                    content = sc.nextLine();
                    System.out.print("작가 : ");
                    author = sc.nextLine();


                    int temp_number = ++number;

                    System.out.printf("%d번 명언이 등록되었습니다.\n", temp_number);

                    String s_temp_number = String.valueOf(temp_number);
                    maximSet[0] = s_temp_number;
                    maximSet[1] = content;
                    maximSet[2] = author;

                    AllList.add(maximSet);
                    break;

                case "목록":
                    System.out.println("  번호   /   작가   /   명언  ");
                    System.out.println("----------------------");
                    
                    for(int i = 0; i < AllList.size(); i++){

                        System.out.printf("  %s  /  %s  /  %s  \n", AllList.get(i)[0], AllList.get(i)[0], AllList.get(i)[0]);
                    }
                    break;

                case "삭제":
                    if(AllList.size() == 0){
                        System.out.println("등록된 명언이 없습니다. 명언을 입력하세요.");
                        break;
                    }

                    String[] idList = new String[2];
                    idList = cmdSet[1].split("=", 2);
                    int id = Integer.parseInt(idList[1]);
                    AllList.remove(id - 1);

                    System.out.printf("%d번 명언이 삭제되었습니다.\n", id);
                    break;

                case "수정":
                    if(AllList.size() == 0){
                        System.out.println("등록된 명언이 없습니다. 명언을 입력하세요.");
                        break;
                    }
                    String[] modify_idList = new String[2];
                    modify_idList = cmdSet[1].split("=", 2);
                    int id2 = Integer.parseInt(modify_idList[1]);

                    if(AllList.get(id2 - 1) == null){
                        System.out.printf("%s번 명언은 존재하지 않습니다. 다시 입력해주세요.\n", modify_idList[0]);
                    }

                    System.out.printf("%d번 명언을 수정합니다.\n", id2);

                    System.out.print("변경할 명언을 입력해주세요. : ");
                    String temp_content = sc.nextLine();

                    System.out.print("변경할 작가명을 입력하세요 : ");
                    String temp_author = sc.nextLine();

                    String[] temp_array = {Integer.toString(id2), temp_content, temp_author};
                    AllList.set(id2 - 1, temp_array);

                    System.out.printf("%d번 명언이 수정되었습니다.\n", id2);
                    break;


                case "종료":
                    break outer;


            }
        }

    }
}
