package policy.reinforcement.optimization;

import policy.Action;
import policy.reinforcement.Function;
import policy.reinforcement.optimization.annealing.AnnealingSimulation;
import policy.reinforcement.optimization.annealing.CauchyMutator;
import policy.reinforcement.optimization.annealing.OptimizationProblem;

public class SimulatedAnnealingOptimizer implements Optimiser {
    @Override
    public Action findSolution(Function<Action> function) {

        AnnealingSimulation simulation = new AnnealingSimulation(new OptimalActionProblem(function), new CauchyMutator());
        simulation.setStartingTemperature(0.01);
        simulation.setMaxIteration(10000);

        double[] solution = simulation.search();

        return new Action(Math.tanh(solution[0]), Math.tanh(solution[1]));
    }

    private static class OptimalActionProblem implements OptimizationProblem
    {

        Function<Action> function;

        public OptimalActionProblem(Function<Action> function) {
            this.function = function;
        }

        @Override
        public double[] initState() {
            return new double[]{0, 0};
        }

        @Override
        public double evaluate(double[] arguments) {

            double value = function.calculate(new Action(Math.tanh(arguments[0]), Math.tanh(arguments[1])));

            return value;
        }
    }
}
