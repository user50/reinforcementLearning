import com.example.montecarlo.Step;
import policy.CodeRacingAction;
import policy.CodeRacingState;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Step<CodeRacingState, CodeRacingAction>> steps = new CodeRacingSimulator().generateEpisode(null);
    }
}
