package com.example;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
class TeamInfoTest {

    private TeamInfo teamInfo;

    @BeforeEach
    void setUp() {
        teamInfo = new TeamInfo();
        teamInfo.setNum_of_Games(10);
        teamInfo.setSpecializationS(new String[] {"123", "456"});
        teamInfo.setOposTeamS(new String[] {"123", "456"});
        teamInfo.setData1(new String[][] {{"123", "456"}, {"789", "91011"}});
        teamInfo.setData2(new String[][] {{"123", "456"}, {"789", "91011"}});
    }

    @Test
    void testFaceMethod() {
        // Проверяем, что все компоненты инициализированы после вызова face()
        teamInfo.face();

        assertNotNull(teamInfo.gameinfo);
        assertNotNull(teamInfo.playerinfo);
        assertNotNull(teamInfo.Name);
        assertNotNull(teamInfo.num_of_games);

        // Проверяем, что размеры компонентов установлены
        assertEquals(700, teamInfo.gameinfo.getWidth());
        assertEquals(700, teamInfo.gameinfo.getHeight());

        // Проверяем, что модели таблиц заполнены данными
        assertNotNull(teamInfo.model1);
        assertNotNull(teamInfo.data1);
        assertTrue(teamInfo.data1.length > 0);

        assertNotNull(teamInfo.model2);
        assertNotNull(teamInfo.data2);
        assertTrue(teamInfo.data2.length > 0);

        // Проверяем, что комбо-боксы заполнены данными
        assertNotNull(teamInfo.Specialization);
        assertNotNull(teamInfo.OposTeam);
        assertFalse(teamInfo.Specialization.getItemCount() == 0);
        assertFalse(teamInfo.OposTeam.getItemCount() == 0);
    }

    @Test
    void testDeleteElementGameTable() {
        // Добавляем элемент в таблицу игр
        String[][] data1 = {{"1", "Opponent1", "10", "20", "2023-01-01"}};
        teamInfo.setData1(data1);
        teamInfo.face();

        // Проверяем, что элемент добавлен в таблицу
        assertEquals(1, teamInfo.games.getRowCount());

        // Удаляем последний элемент
        teamInfo.delete_el1.doClick();

        // Проверяем, что элемент удален из таблицы
        assertEquals(0, teamInfo.games.getRowCount());
    }

    @Test
    void testDeleteElementPlayerTable() {
        // Добавляем элемент в таблицу игроков
        String[][] data2 = {{"1", "Player1", "Win", "Specialist"}};
        teamInfo.setData2(data2);
        teamInfo.face();

        // Проверяем, что элемент добавлен в таблицу
        assertEquals(1, teamInfo.players.getRowCount());

        // Удаляем последний элемент
        teamInfo.delete_el2.doClick();

        // Проверяем, что элемент удален из таблицы
        assertEquals(0, teamInfo.players.getRowCount());
    }
}