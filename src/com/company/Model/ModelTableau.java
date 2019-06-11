package com.company.Model;

import com.company.Controller.Connexion;
import javax.swing.table.AbstractTableModel;
import java.sql.SQLException;
import java.util.ArrayList;

// Modèle du tableau qui se veut dynamique (par rapport à l'élément envoyer en paramètre)
public class ModelTableau extends AbstractTableModel {

    private ArrayList<Requete> list;
    private String[] header;
    private String table;

    private Connexion connexion;

    public ModelTableau(Connexion connexion, ArrayList list, String[] header, String table) {
        super();
        this.connexion = connexion;
        this.list = list;
        this.header = header;
        this.table = table;

        try {
            this.list = this.connexion.remplirChampsRequete("SELECT * FROM "+this.table, this.table);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public int getRowCount() {
        return this.list.size();
    }

    public int getColumnCount() {
        return this.header.length;
    }

    public String getColumnName(int columnIndex) {
        return this.header[columnIndex];
    }

    public Object getValueAt(int rowIndex, int columnIndex) {

        if (this.table.equals("Personne")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                default:
                    return null; //Ne devrait jamais arriver
            }
        } else if (this.table.equals("Niveau")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                default:
                    return null; //Ne devrait jamais arriver
            }
        } else if (this.table.equals("Classe")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                case 4:
                    return list.get(rowIndex).getValueAt(4);
                default:
                    return null; //Ne devrait jamais arriver
            }
        } else if (this.table.equals("Inscription")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                default:
                    return null; //Ne devrait jamais arriver
            }
        }else if (this.table.equals("Ecole")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                default:
                    return null; //Ne devrait jamais arriver
            }
        }else if (this.table.equals("Trimestre")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                case 4:
                    return list.get(rowIndex).getValueAt(4);
                default:
                    return null; //Ne devrait jamais arriver
            }
        }else if (this.table.equals("Bulletin")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                default:
                    return null; //Ne devrait jamais arriver
            }
        }else if (this.table.equals("Evaluation")){
            switch(columnIndex){
                case 0:
                    return list.get(rowIndex).getValueAt(0);
                case 1:
                    return list.get(rowIndex).getValueAt(1);
                case 2:
                    return list.get(rowIndex).getValueAt(2);
                case 3:
                    return list.get(rowIndex).getValueAt(3);
                default:
                    return null; //Ne devrait jamais arriver
            }
        }
        else {return null;}
    }

    public void addItem(Requete t) {
        try {
            System.out.println(t.requeteAdd());
            this.connexion.executeUpdate(t.requeteAdd());
            this.list.add(t);
            fireTableRowsInserted(this.list.size() -1, this.list.size() -1);
        } catch (SQLException e) {
            System.out.println("Requete failed : ADD");
        }
    }

    public void removeItem(int rowIndex) {
        try {
            this.connexion.executeUpdate("DELETE FROM "+this.table+" WHERE Id = " + this.list.get(rowIndex).getId());
        } catch (SQLException e) {
            System.out.println("Requete failed : DELETE");
        }
        this.list.remove(rowIndex);
        fireTableRowsDeleted(rowIndex, rowIndex);
    }

    public ModelTableau rechercheItem(int rowIndex) throws SQLException, ClassNotFoundException {
        this.list = this.list.get(rowIndex).recherche(this.connexion);
        this.header = this.list.get(0).getEntetes();
        this.table = this.list.get(0).toString();
        fireTableDataChanged();
        fireTableStructureChanged();
        return this;
    }

    public ModelTableau changeItemOnClick(ArrayList list){
        this.list = list;
        this.header = this.list.get(0).getEntetes();
        this.table = this.list.get(0).toString();
        fireTableDataChanged();
        fireTableStructureChanged();
        return this;
    }

    public ArrayList<Requete> getList() {
        return list;
    }

    public String[] getHeader() {
        return header;
    }

    public String getTable() {
        return table;
    }
}
