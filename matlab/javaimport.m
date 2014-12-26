javaaddpath 'd:\projects\reinforcementLearning\reinforcementLearning.jar'
import com.example.*
import com.example.problem.*
import com.example.learning.*

builder = NArmedBanditProblemBuilder(10, NormalRandomGenerator(0, 1), NormalRandomGenerator(1, 1) );
problem = builder.build();
greedyStrategy = EGreedyStrategy(ActionValueFunction(10), 10, 0.01);
softMaxStrategy = SoftMaxStrategy(ActionValueFunction(10),10, LinearCooling(100) );

