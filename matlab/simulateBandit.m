function [value, optimal] = simulateBandit( machine, maxGames, exploration, problem, strategy )
import com.example.*
value = zeros(1, maxGames);
optimal = zeros(1,maxGames);

simulator = Simulator(maxGames, problem, strategy);
result = simulator.simulate();

for i = 1:result.size()
    value(i) = result.get(i-1).getValue();
    optimal(i) = result.get(i-1).getOptimal();
end

value = cumsum(value)./(1:length(value));
optimal = cumsum(optimal)./(1:length(optimal));

end

