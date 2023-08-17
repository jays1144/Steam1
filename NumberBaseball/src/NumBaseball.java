import java.util.*;
import java.util.stream.IntStream;

public class NumBaseball {

    public final int GuessDigit = 3;
    private int TryCount;
    private final ArrayList<Integer> targetNum = new ArrayList(GuessDigit);

    public NumBaseball()
    {
        Random ran = new Random();

        if (!targetNum.isEmpty()) targetNum.clear();

        ArrayList<Integer> NumPool = new ArrayList<Integer>();
        for(int i = 0; i < 10; i++)
        {
            NumPool.add(i);
        }

        for (int v = GuessDigit - 1, i = 9; v >= 0; v--, i--)
        {
            int selectIndex = ran.nextInt(i);
            targetNum.add(NumPool.get(selectIndex));
            NumPool.remove(selectIndex);
        }
    }
    protected  ArrayList<Integer> OnInput()
    {
        Scanner sc = new Scanner(System.in);

        String input =  sc.next();
        char[] input_char = input.toCharArray();
        ArrayList<Integer> result = new ArrayList<Integer>(GuessDigit);

        if (input_char.length != GuessDigit)
        {
            System.out.println("오류 : 추측 숫자갯수가 틀립니다. " + GuessDigit + "개 만큼 입력해 주세요.");
            return null;
        }//wrong Size

        for (int v = 0; v < GuessDigit; v++)
        {
            if (input_char[v] < 48 || input_char[v] > 57) {
                System.out.println("오류 : 숫자만 적어 주세요.");
                return null;
            }//Not Number

            int Conveted = Integer.parseInt(String.valueOf(input_char[v]));

            if (result.contains(Conveted))
            {
                System.out.println("오류 : 중복된 숫자가 존재합니다.");
                return null;
            }//Overlap

            result.add(Conveted);
        }
        return result;
    }
    public int OnTry()
    {

        ArrayList<Integer> tryInput = new ArrayList<>(GuessDigit);

        int ball = 0;
        int strike = 0;

        while (strike < GuessDigit)
        {
            ball = 0;
            strike = 0;
            System.out.println((TryCount + 1) + "번째 시도 : ");
            tryInput = OnInput();

            if (tryInput == null)
            {
                System.out.println("에러 : 입력 오류");
            }else
            {
                TryCount++;

                //System.out.println(targetNum + " / " + tryInput);

                for(int i = 0; i < GuessDigit; i++)
                {
                    if (targetNum.get(i) == tryInput.get(i))
                    {
                        strike++;
                    }else
                    {
                        ball += targetNum.contains(tryInput.get(i)) ? 1 : 0;
                    }
                }//Set Ball, Strike

                {
                    if (ball > 0 || strike > 0)
                    {
                        System.out.println
                                (
                                        ((ball > 0)? (ball + "B ") : "")
                                                + ((strike > 0)? (strike + "S") : "")
                                );
                    }else
                    {
                        System.out.println("감나빗!");
                    }
                }//Input Result
            }
        }

        return TryCount;
    }
}
