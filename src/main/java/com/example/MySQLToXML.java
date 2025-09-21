package com.example;

import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class MySQLToXML {
    public void convert(String persistenceName, String how_much) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory(persistenceName);
        EntityManager em = emf.createEntityManager();
        StringBuilder xml;
        em.getTransaction().begin();
        if (how_much == "all"){
            List<Specialization> Spsql = em.createQuery("FROM Specialization", Specialization.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<specializations>");
            for (Specialization pp : Spsql) {
                xml.append("\n\n    <specialization>\n");
                xml.append("        <Specialization_id type=\"INT\">");          
                xml.append(pp.getSpId());
                xml.append("</Specialization_id>\n");
                xml.append("        <SpecName type=\"VARCHAR\">");
                xml.append(pp.getSpecName());
                xml.append("</SpecName>\n");
                xml.append("    </specialization>");
            }
            xml.append("\n\n</specializations>");
            try { java.io.FileWriter writer = new FileWriter("specializations.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            List<Player> Plsql = em.createQuery("FROM Player", Player.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<players>");
            for (Player pp : Plsql) {
                xml.append("\n\n    <player>\n");
                xml.append("        <idPlayer type=\"INT\">");          
                xml.append(pp.getPlId());
                xml.append("</idPlayer>\n");
                xml.append("        <PlayerName type=\"VARCHAR\">");
                xml.append(pp.getPlayerName());
                xml.append("</PlayerName>\n");
                xml.append("        <result type=\"INT\">");
                xml.append(pp.getResult());
                xml.append("</result>\n");
                xml.append("        <special type=\"INT\">");
                xml.append(pp.getspecial());
                xml.append("</special>\n");
                xml.append("    </player>");
            }
            xml.append("\n\n</players>");
            try { java.io.FileWriter writer = new FileWriter("players.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


        List<Game> Gsql = em.createQuery("FROM Game", Game.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<games>");
            for (Game pp : Gsql) {
                xml.append("\n\n    <game>\n");
                xml.append("        <idGame type=\"INT\">");          
                xml.append(pp.GetGId());
                xml.append("</idGame>\n");
                xml.append("        <opositeTeam type=\"INT\">");
                xml.append(pp.GetOpositeTeam());
                xml.append("</opositeTeam>\n");
                xml.append("        <firstScore type=\"INT\">");
                xml.append(pp.GetFirstScore());
                xml.append("</firstScore>\n");
                xml.append("        <secondScore type=\"INT\">");
                xml.append(pp.GetSecondScore());
                xml.append("</secondScore>\n");
                xml.append("        <Date type=\"VARCHAR\">");
                xml.append(pp.GetDate());
                xml.append("</Date>\n");
                xml.append("    </game>");
            }
            xml.append("\n\n</games>");
            try { java.io.FileWriter writer = new FileWriter("games.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }


            List<OpositeTeam> OTsql = em.createQuery("FROM OpositeTeam", OpositeTeam.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<opositeteams>");
            for (OpositeTeam pp : OTsql) {
                xml.append("\n\n    <opositeteam>\n");
                xml.append("        <idopositeTeam type=\"INT\">");          
                xml.append(pp.getOpositeTeam_id());
                xml.append("</idopositeTeam>\n");
                xml.append("        <opositeTeamName type=\"VARCHAR\">");
                xml.append(pp.getopositeTeamName());
                xml.append("</opositeTeamName>\n");
                xml.append("    </opositeteam>");
            }
            xml.append("\n\n</opositeteams>");
            try { java.io.FileWriter writer = new FileWriter("opositeteams.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (how_much == "gm") {
            List<Game> Gsql = em.createQuery("FROM Game", Game.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<games>");
            for (Game pp : Gsql) {
                xml.append("\n\n    <game>\n");
                xml.append("        <idGame type=\"INT\">");          
                xml.append(pp.GetGId());
                xml.append("</idGame>\n");
                xml.append("        <opositeTeam type=\"INT\">");
                xml.append(pp.GetOpositeTeam());
                xml.append("</opositeTeam>\n");
                xml.append("        <firstScore type=\"INT\">");
                xml.append(pp.GetFirstScore());
                xml.append("</firstScore>\n");
                xml.append("        <secondScore type=\"INT\">");
                xml.append(pp.GetSecondScore());
                xml.append("</secondScore>\n");
                xml.append("        <Date type=\"VARCHAR\">");
                xml.append(pp.GetDate());
                xml.append("</Date>\n");
                xml.append("    </game>");
            }
            xml.append("\n\n</games>");
            try { java.io.FileWriter writer = new FileWriter("games.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if (how_much == "pl") {
            List<Player> Plsql = em.createQuery("FROM Player", Player.class).getResultList();
            xml = new StringBuilder();
            xml.append("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n<players>");
            for (Player pp : Plsql) {
                xml.append("\n\n    <player>\n");
                xml.append("        <idPlayer type=\"INT\">");          
                xml.append(pp.getPlId());
                xml.append("</idPlayer>\n");
                xml.append("        <PlayerName type=\"VARCHAR\">");
                xml.append(pp.getPlayerName());
                xml.append("</PlayerName>\n");
                xml.append("        <result type=\"INT\">");
                xml.append(pp.getResult());
                xml.append("</result>\n");
                xml.append("        <special type=\"INT\">");
                xml.append(pp.getspecial());
                xml.append("</special>\n");
                xml.append("    </player>");
            }
            xml.append("\n\n</players>");
            try { java.io.FileWriter writer = new FileWriter("players.xml");
            writer.write(xml.toString());
            writer.close();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        } 
    }
}