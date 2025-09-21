package com.example;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import java.io.File;
import java.io.IOException;

import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;
import org.w3c.dom.Node;
import org.w3c.dom.Element;
import java.util.ArrayList;
import java.util.List; 

public class XmlParser {
    public List<Specialization> SpecializationConvert(String xmlPath) {
        List<Specialization> xmldata = new ArrayList<>();
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
            NodeList rows = document.getElementsByTagName("specialization");
            for (int i = 0; i < rows.getLength(); i++) {
                Node node = rows.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    
                    int Specialization_id = Integer.parseInt(row.getElementsByTagName("Specialization_id").item(0).getTextContent());
                    String specName = row.getElementsByTagName("SpecName").item(0).getTextContent();
                    
                    Specialization spec = new Specialization ();
                    spec.setSpId(Specialization_id);
                    spec.setSpecName(specName);
                    xmldata.add(spec);
                }
            }   
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
        System.err.println("Ошибка при парсинге XML: " + e.getMessage());
        return null;
        }
        return xmldata;
    }
    public List<Game> GameConvert(String xmlPath) {
        List<Game> xmldata = new ArrayList<>();
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
            NodeList rows = document.getElementsByTagName("game");
            for (int i = 0; i < rows.getLength(); i++) {
                Node node = rows.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    
                    int idGame = Integer.parseInt(row.getElementsByTagName("idGame").item(0).getTextContent());
                    int opositeTeam = Integer.parseInt(row.getElementsByTagName("opositeTeam").item(0).getTextContent());
                    int firstScore = Integer.parseInt(row.getElementsByTagName("firstScore").item(0).getTextContent());
                    int secondScore = Integer.parseInt(row.getElementsByTagName("secondScore").item(0).getTextContent());
                    String Date = row.getElementsByTagName("Date").item(0).getTextContent();
                    Game G = new Game ();
                    G.SetGId(idGame);
                    G.SetOpositeTeam(opositeTeam);
                    G.SetFirstScore(firstScore);
                    G.SetSecondScore(secondScore);
                    G.SetDate(Date);
                    xmldata.add(G);
                }
            }   
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
        System.err.println("Ошибка при парсинге XML: " + e.getMessage());
        return null;
        }
        return xmldata;
    }
    public List<Player> PlayerConvert(String xmlPath) {
        List<Player> xmldata = new ArrayList<>();
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
            NodeList rows = document.getElementsByTagName("player");
            for (int i = 0; i < rows.getLength(); i++) {
                Node node = rows.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    
                    int idPlayer = Integer.parseInt(row.getElementsByTagName("idPlayer").item(0).getTextContent());
                    String PlayerName = row.getElementsByTagName("PlayerName").item(0).getTextContent();
                    String result = row.getElementsByTagName("result").item(0).getTextContent();
                    int special = Integer.parseInt(row.getElementsByTagName("special").item(0).getTextContent());
                    
                    Player P = new Player();
                    P.SetPlId(idPlayer);
                    P.setPlayerName(PlayerName);
                    P.setResult(result);
                    P.setspecial(special);
                    xmldata.add(P);
                }
            }   
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
        System.err.println("Ошибка при парсинге XML: " + e.getMessage());
        return null;
        }
        return xmldata;
    }
    public List<OpositeTeam> OpositeTeamConvert(String xmlPath) {
        List<OpositeTeam> xmldata = new ArrayList<>();
        try{
            Document document = DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(new File(xmlPath));
            NodeList rows = document.getElementsByTagName("opositeteam");
            for (int i = 0; i < rows.getLength(); i++) {
                Node node = rows.item(i);
                if (node.getNodeType() == Node.ELEMENT_NODE) {
                    Element row = (Element) node;
                    
                    int idopositeTeam = Integer.parseInt(row.getElementsByTagName("idopositeTeam").item(0).getTextContent());
                    String opositeTeamName = row.getElementsByTagName("opositeTeamName").item(0).getTextContent();
                    
                    OpositeTeam OT = new OpositeTeam();
                    OT.setOpositeTeam_id(idopositeTeam);
                    OT.setOpositeTeamName(opositeTeamName);
                    xmldata.add(OT);
                }
            }   
        }
        catch (ParserConfigurationException | SAXException | IOException e) {
        System.err.println("Ошибка при парсинге XML: " + e.getMessage());
        return null;
        }
        return xmldata;
    }
}   