package lt.vu.mybatis.dao;

import java.util.List;
import java.util.Map;

import lt.vu.mybatis.model.Player;
import lt.vu.mybatis.model.Team;
import lt.vu.mybatis.model.Training;
import org.mybatis.cdi.Mapper;

@Mapper
public interface PlayerMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int insert(Player record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    Player selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    List<Player> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.PLAYER
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int updateByPrimaryKey(Player record);

    List<Training> selectTrainingsForPlayers(int id);
    Team findTeamByPlayerId(int id);

    Training selectTeam(int team_id);

    void addPlayerToTraining(Map<String, Object> params);
}