SELECT nextState.target_direction, nextState.wheel_turn, action.delta_wheel_turn, transition.value,  decision.value, transition.value/decision.value FROM reinforcement.transition
JOIN state ON state.id = transition.state_id AND state.target_direction = 0 AND state.wheel_turn = 0
JOIN state as nextState ON nextState.id = transition.next_state_id
JOIN action ON action.id = transition.action_id
JOIN decision ON decision.action_id = `action`.id AND decision.state_id = state.id;


