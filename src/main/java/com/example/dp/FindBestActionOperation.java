package com.example.dp;

import com.example.common.*;
import com.example.dp.accessors.AccessActionByStateValueFunction;

/**
 * Created by user50 on 07.01.2015.
 */
public interface FindBestActionOperation<S extends State, A extends Action> {

    A find(S state);

}
