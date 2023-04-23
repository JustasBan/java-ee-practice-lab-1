package lt.vu.mybatis.dao;

import java.util.List;
import lt.vu.mybatis.model.Team;

public interface TeamMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int insert(Team record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    Team selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    List<Team> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table PUBLIC.TEAM
     *
     * @mbg.generated Sun Apr 23 20:32:35 EEST 2023
     */
    int updateByPrimaryKey(Team record);
}