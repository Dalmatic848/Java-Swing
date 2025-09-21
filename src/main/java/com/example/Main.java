package com.example;
import javax.persistence.*;

import net.sf.jasperreports.engine.JRException;
import java.sql.SQLException;
import java.util.List;

public class Main {
    private static String From_id_to_spec(int id, String[] sp) {
        int i = 1;
        String spec = new String();
        for (String j : sp) {
            if (i == id + 1) {
                spec = j;
            }
            i = i + 1;
        }
        return spec;
    }
    private static String From_id_OT(int id, String[] ots) {
        int i = 1;
        String ot = new String();
        for (String j : ots) {
            if (i == id + 1) {
                ot = j;
            }
            i = i + 1;
        }
        return ot;
    }
    
    public static void main(String[] args)  throws JRException, SQLException{
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("test_persistence");
        EntityManager em = emf.createEntityManager();

        em.getTransaction().begin();

        List<Specialization> spsql = em.createQuery("FROM Specialization", Specialization.class).getResultList();
        String[] spS = new String[spsql.size() + 1];
        spS[0] = "Специализация";
        int i = 1;
        for (Specialization j: spsql) {
            spS[i] = j.getSpecName();
            i = i + 1;
        }

        List<OpositeTeam> OTsql = em.createQuery("FROM OpositeTeam", OpositeTeam.class).getResultList();
        String[] OTS = new String[OTsql.size() + 1];
        OTS[0] = "Команда соперников";
        i = 1;
        for (OpositeTeam j : OTsql) {
            OTS[i] = j.getopositeTeamName();
            i = i + 1;
        }


        Team My_team = new Team();
        My_team.SetTeamName("Зенит");

        List<Player> Psql = em.createQuery("FROM Player", Player.class).getResultList();
        My_team.SetList_of_players(Psql);
        String[][] D2 = new String[Psql.size()][4];
        i = 0;
        for (Player j : Psql) {
            D2[i][0] = String.valueOf(j.getPlId());
            D2[i][1] = j.getPlayerName();
            D2[i][2] = j.getResult();
            D2[i][3] = From_id_to_spec(j.getspecial(), spS);
            i = i + 1;
        }

        List<Game> Gsql = em.createQuery("FROM Game", Game.class).getResultList();
        My_team.SetList_of_games(Gsql);
        String[][] D1 = new String[(Gsql.size())][5];
        i = 0;
        for (Game j : Gsql) {
            D1[i][0] = String.valueOf(j.GetGId());
            D1[i][1] = From_id_OT(j.GetOpositeTeam(), OTS);
            D1[i][2] = String.valueOf(j.GetFirstScore());
            D1[i][3] = String.valueOf(j.GetSecondScore());
            D1[i][4] = j.GetDate();
            i = i + 1;
        }
        

        My_team.SetNum_of_games(Gsql.size()); // из таблицы путем подсчета количество строк в таблице с играми
        
        
        TeamInfo a = new TeamInfo(My_team.GetTeamName());
        a.setNum_of_Games(My_team.GetNum_of_games());
        a.setOposTeamS(OTS);
        a.setSpecializationS(spS);
        a.setData1(D1);
        a.setData2(D2);
        a.face();
        em.getTransaction().commit();
    }
}
/*Задание 7. Разработать ПК для администратора футбольной команды. В ПК должна храниться информация об игроках команды, календарь и результаты игр.  
Администратор футбольной команды может добавлять, изменять и удалять эту информацию. Ему могут потребоваться следующие сведения:
•	список футболистов и их специализация;
•	календарь игр;
•	количество проведенных игр;
•	отчета о результативности каждого игрока команды*/