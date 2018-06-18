package com.yb.dao;

import com.yb.entity.Remind;
import org.apache.ibatis.annotations.Param;
import org.junit.runners.Parameterized;

import java.util.List;

public interface RemindDao {

    void insert(@Param("remind") Remind remind);
    //查询需要提醒的数据
    List<Remind> queryAllByMatchId(@Param("matchId") Integer matchId);
    //改变数据状态,发完提醒，就改变状态
    void updateStatus(@Param("ids") List<Integer> ids);

    Remind queryByMatchIdAndUid(@Param("uid")String uid,@Param("matchId")Integer matchId);

}
