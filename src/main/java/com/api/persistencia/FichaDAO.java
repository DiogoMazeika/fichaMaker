package com.api.persistencia;

import com.api.entidade.Ficha;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class FichaDAO extends GenericDAO {

    public void inserir(Ficha ficha){
        String sql = """
            INSERT INTO fichas
            (	
                nome,
                class_nivel,
                antecedente,
                raca,
                alinhamento,
                forca,
                destreza,
                constituicao,
                inteligencia,
                sabedoria,
                carisma,
                inspiracao,
                proficiencia,
                armadura,
                deslocamento,
                vida_max,
                dado_vida,
                equipamento,
                personalidade,
                ideais,
                vinculos,
                fraquezas,
                caracteristicas
            ) VALUES
            (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)
                """;
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,ficha.getNome());
            p.setString(2,ficha.getClass_nivel());
            p.setString(3,ficha.getAntecedente());
            p.setString(4,ficha.getRaca());
            p.setString(5,ficha.getAlinhamento());
            p.setString(6,ficha.getForca());
            p.setString(7,ficha.getDestreza());
            p.setString(8,ficha.getConstituicao());
            p.setString(9,ficha.getInteligencia());
            p.setString(10,ficha.getSabedoria());
            p.setString(11,ficha.getCarisma());
            p.setString(12,ficha.getInspiracao());
            p.setString(13,ficha.getProficiencia());
            p.setString(14,ficha.getArmadura());
            p.setString(15,ficha.getDeslocamento());
            p.setString(16,ficha.getVida_max());
            p.setString(17,ficha.getDado_vida());
            p.setString(18,ficha.getEquipamento());
            p.setString(19,ficha.getPersonalidade());
            p.setString(20,ficha.getIdeais());
            p.setString(21,ficha.getVinculos());
            p.setString(22,ficha.getFraquezas());
            p.setString(23,ficha.getCaracteristicas());
            p.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao inserir ficha");
            e.printStackTrace();
        }
    }

    public void inserir2(){
        String sql = """
            INSERT INTO fichas
            (	
                nome,
                class_nivel,
                antecedente,
                raca,
                alinhamento,
                forca,
                destreza,
                constituicao,
                inteligencia,
                sabedoria,
                carisma,
                inspiracao,
                proficiencia,
                armadura,
                deslocamento,
                vida_max,
                dado_vida,
                equipamento,
                personalidade,
                ideais,
                vinculos,
                fraquezas,
                caracteristicas
            ) VALUES
            ('teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste', 'teste')
                """;
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            // p.setString(1,ficha.getNome());
            // p.setString(2,ficha.getClass_nivel());
            // p.setString(3,ficha.getAntecedente());
            // p.setString(4,ficha.getRaca());
            // p.setString(5,ficha.getAlinhamento());
            // p.setString(6,ficha.getForca());
            // p.setString(7,ficha.getDestreza());
            // p.setString(8,ficha.getConstituicao());
            // p.setString(9,ficha.getInteligencia());
            // p.setString(10,ficha.getSabedoria());
            // p.setString(11,ficha.getCarisma());
            // p.setString(12,ficha.getInspiracao());
            // p.setString(13,ficha.getProficiencia());
            // p.setString(14,ficha.getArmadura());
            // p.setString(15,ficha.getDeslocamento());
            // p.setString(16,ficha.getVida_max());
            // p.setString(17,ficha.getDado_vida());
            // p.setString(18,ficha.getEquipamento());
            // p.setString(19,ficha.getPersonalidade());
            // p.setString(20,ficha.getIdeais());
            // p.setString(21,ficha.getVinculos());
            // p.setString(22,ficha.getFraquezas());
            // p.setString(23,ficha.getCaracteristicas());
            p.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao inserir ficha");
            e.printStackTrace();
        }
    }

    /* public void atualizar(Tarefa tarefa){
        String sql = """
                update tarefa set descricao  = ?
                                 ,finalizado = ?
                where id_tarefa = ?             
                """;
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setString(1,tarefa.getDescricao());
            p.setBoolean(2,tarefa.isFinalizado());
            p.setLong(3,tarefa.getId());
            p.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao atualizar tarefa "+tarefa);
            e.printStackTrace();
        }
    }

    public void deletar(Tarefa tarefa){
        String sql = """
                delete from tarefa where id_tarefa = ?             
                """;
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setLong(1,tarefa.getId());
            p.executeUpdate();
        }catch (SQLException e){
            System.out.println("Erro ao deletar tarefa "+tarefa);
            e.printStackTrace();
        }
    }

    public Optional<Tarefa> obterPeloId(long id){
        String sql = """
                select id_tarefa, descricao, finalizado
                from tarefa where id_tarefa = ?             
                """;
        Tarefa t = null;
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setLong(1,id);
            ResultSet r = p.executeQuery();
            if(r.next()){
                t = new Tarefa();
                t.setId(r.getLong("id_tarefa"));
                t.setDescricao(r.getString("descricao"));
                t.setFinalizado(r.getBoolean("finalizado"));
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter tarefa com id "+id);
            e.printStackTrace();
        }
        return Optional.of(t);
    }

    public List<Tarefa> obterTodos(){
        String sql = """
                select id_tarefa, descricao, finalizado
                from tarefa        
                """;
        List<Tarefa> lista = new ArrayList<>();
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            ResultSet r = p.executeQuery();
            while(r.next()){
                Tarefa t = new Tarefa();
                t.setId(r.getLong("id_tarefa"));
                t.setDescricao(r.getString("descricao"));
                t.setFinalizado(r.getBoolean("finalizado"));
                lista.add(t);
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter todas as tarefas ");
            e.printStackTrace();
        }
        return lista;
    }

    public List<Tarefa> obter(boolean finalizado) {
        String sql = """
                select id_tarefa, descricao, finalizado
                from tarefa where finalizado = ?       
                """;
        List<Tarefa> lista = new ArrayList<>();
        try(Connection c = conn();
            PreparedStatement p = c.prepareStatement(sql)){
            p.setBoolean(1,finalizado);
            ResultSet r = p.executeQuery();
            while(r.next()){
                Tarefa t = new Tarefa();
                t.setId(r.getLong("id_tarefa"));
                t.setDescricao(r.getString("descricao"));
                t.setFinalizado(r.getBoolean("finalizado"));
                lista.add(t);
            }
        }catch (SQLException e){
            System.out.println("Erro ao obter todas as tarefas ");
            e.printStackTrace();
        }
        return lista;
    } */
}
