package com.bcopstein.CtrlCorredorV1.repository;

import com.bcopstein.CtrlCorredorV1.model.Corredor;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class CorredorRepositoryImpl implements CorredorRepository {
    private JdbcTemplate jdbcTemplate;

    public CorredorRepositoryImpl(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;

        this.jdbcTemplate.execute("DROP TABLE corredores IF EXISTS");
        this.jdbcTemplate.execute("CREATE TABLE corredores("
                + "cpf VARCHAR(255), nome VARCHAR(255), genero VARCHAR(255), diaDn int, mesDn int, anoDn int, PRIMARY KEY(cpf))");

        this.jdbcTemplate.batchUpdate(
                "INSERT INTO corredores(cpf,nome,genero,diaDn,mesDn,anoDn) VALUES ('10001287','Luiz','masculino',22,5,1987)");
    }

    @Override
    public List<Corredor> findAll() {
         return this.jdbcTemplate.query("SELECT * from corredores",
                (rs, rowNum) -> new Corredor(rs.getString("cpf"), rs.getString("nome"), rs.getInt("diaDn"),
                        rs.getInt("mesDn"), rs.getInt("anoDn"), rs.getString("genero")));
    }

    @Override
    public boolean saveCorredor(Corredor corredor) {
        // Limpa a base de dados
        this.jdbcTemplate.batchUpdate("DELETE from Corredores");
        // Então cadastra o novo "corredor único"
        this.jdbcTemplate.update("INSERT INTO corredores(cpf,nome,diaDn,mesDn,anoDn,genero) VALUES (?,?,?,?,?,?)",
                corredor.getCpf(), corredor.getNome(), corredor.getDiaDn(), corredor.getMesDn(), corredor.getAnoDn(),
                corredor.getGenero());
        return true;
    }


}
