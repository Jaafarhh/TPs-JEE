package ma.projet.service;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import ma.projet.beans.Employe;
import ma.projet.beans.Message;
import ma.projet.connexion.Connexion;
import ma.projet.dao.IDao;

public class MessageService implements IDao<Message> {

    private EmployeService es = new EmployeService();

    @Override
    public boolean create(Message o) {
        try {
            String req = "INSERT INTO message (objet, sujet, date, idE, idR) VALUES (?, ?, ?, ?, ?)";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setString(1, o.getObject());
            ps.setString(2, o.getSujet());
            ps.setDate(3, new java.sql.Date(o.getDate().getTime()));
            ps.setInt(4, o.getEmpEmetteur().getId());
            ps.setInt(5, o.getEmpRecepteur().getId());
            return ps.executeUpdate() == 1;
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }

    @Override
    public Message getById(int id) {
        Message message = null;
        try {
            String req = "SELECT * FROM message WHERE id = ?";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                message = new Message(
                        rs.getInt("id"),
                        rs.getString("objet"),
                        rs.getString("sujet"),
                        rs.getDate("date"),
                        es.getById(rs.getInt("idE")),
                        es.getById(rs.getInt("idR"))
                );
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return message;
    }

    @Override
    public List<Message> getAll() {
        List<Message> messages = new ArrayList<>();
        try {
            String req = "SELECT * FROM message";
            PreparedStatement ps = Connexion.getConnection().prepareStatement(req);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                messages.add(new Message(
                        rs.getInt("id"),
                        rs.getString("objet"),
                        rs.getString("sujet"),
                        rs.getDate("date"),
                        es.getById(rs.getInt("idE")),
                        es.getById(rs.getInt("idR"))
                ));
            }
        } catch (SQLException ex) {
            Logger.getLogger(MessageService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return messages;
    }

    public boolean update(Message m) {
        return false;
    }

    public boolean delete(Message m) {
        return false;
    }

}
