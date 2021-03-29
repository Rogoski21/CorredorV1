package com.bcopstein.CtrlCorredorV1.repository;

import com.bcopstein.CtrlCorredorV1.model.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class EventosRepositoryImpl implements EventoRepository {
    private JdbcTemplate jdbcTemplate;

    public EventosRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

        var ids = new int[]{ 1, 2, 3, 4, 5, 6, 7, 8, 9, 10 };
        var nomes = new String[]{ "Evento 1", "Evento 2", "Evento 3", "Evento 4", "Evento 5", "Evento 6", "Evento 7", "Evento 8", "Evento 9", "Evento 10" };
        var dias = new int[] { 23, 18, 10, 11, 28, 8, 9, 4, 7 , 14 };
        var meses = new int[] { 1, 2, 3, 8, 5, 6, 7, 4, 9, 10 };
        var anos = new int[] { 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021, 2021 };
        var distancias = new int[] { 5, 5, 5, 5, 5, 5, 5, 5, 9, 5 };
        var horas = new int[] { 8, 8, 7, 5, 6, 5, 6, 3, 5, 4 };
        var minutos = new int[] { 30, 15, 15, 2, 13, 42, 7, 34, 12, 3 };
        var segundos = new int[] { 4, 45, 12, 23, 43, 54, 30, 39, 31, 10 };

        for (int i = 0; i < 10; i ++) {
            this.jdbcTemplate.batchUpdate(
                    "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                            "(" + ids[i] + ",'" + nomes[i] + "'," + dias[i] + "," + meses[i] + "," + anos[i] + "," + distancias[i] + "," + horas[i] + "," + minutos[i] + "," + segundos[i] +")"
            );
        }

    }

    @Override
    public List<Evento> findAll() {
        List<Evento> resp = this.jdbcTemplate.query("SELECT * from eventos",
                (rs, rowNum) -> new Evento(rs.getInt("id"), rs.getString("nome"), rs.getInt("dia"), rs.getInt("mes"),
                        rs.getInt("ano"), rs.getInt("distancia"), rs.getInt("horas"), rs.getInt("minutos"),
                        rs.getInt("segundos")));
        return resp;
    }

    @Override
    public Boolean saveEvento(Evento evento) {
        this.jdbcTemplate.update(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES (?,?,?,?,?,?,?,?,?)",
                evento.getId(), evento.getNome(), evento.getDia(), evento.getMes(), evento.getAno(),
                evento.getDistancia(), evento.getHoras(), evento.getMinutos(), evento.getSegundos());
        return true;
    }

}
