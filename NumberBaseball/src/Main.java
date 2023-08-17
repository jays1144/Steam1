import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args){
        NumBaseball numBaseball = new NumBaseball();

        System.out.println("컴퓨터가 숫자를 생성하였습니다. 답을 맞춰보세요!");
        int tries = numBaseball.OnTry();
        System.out.println(tries + "번만에 맞히셨습니다. \n 게임을 종료합니다.");

    }
}
