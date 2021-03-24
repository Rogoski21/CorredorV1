package com.bcopstein.CtrlCorredorV1.repository;

import com.bcopstein.CtrlCorredorV1.model.Evento;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;


public class EventosRepositoryImpl implements EventoRepository {
    private JdbcTemplate jdbcTemplate;

    public EventosRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE eventos IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE eventos("
                + "id int, nome VARCHAR(255), dia int, mes int, ano int, distancia int, horas int, minutos int, segundos int,PRIMARY KEY(id))");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                        " ('1','Poa Day Run',22,5,2019,5,0,35,32)");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO eventos(id,nome,dia,mes,ano,distancia,horas,minutos,segundos) VALUES" +
                        " ('2','Zap Run Day',12,6,2020,10,0,35,32)");
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
