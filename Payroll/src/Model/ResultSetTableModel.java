/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Samir
 */
public class ResultSetTableModel implements TableModel{
    ResultSet results;             // The ResultSet to interpret
    ResultSetMetaData metadata;    // Additional information about the results
    int numcols, numrows;          // How many rows and columns in the table

    /**
     * This constructor creates a TableModel from a ResultSet.  It is package
     * private because it is only intended to be used by 
     * ResultSetTableModelFactory, which is what you should use to obtain a
     * ResultSetTableModel
     **/
    public ResultSetTableModel(ResultSet results) throws SQLException {
	this.results = results;                 // Save the results
	metadata = results.getMetaData();       // Get metadata on them
	numcols = metadata.getColumnCount();    // How many columns?
	results.last();                         // Move to last row
	numrows = results.getRow();             // How many rows?
    }
    
    // These two TableModel methods return the size of the table
    @Override
    public int getColumnCount() { 
        return numcols; 
    }
    
    @Override
    public int getRowCount() { 
        return numrows; 
    }

    // This TableModel method returns columns names from the ResultSetMetaData
    @Override
    public String getColumnName(int column) {
	try {
	    return metadata.getColumnLabel(column+1);
	} catch (SQLException e) { return e.toString(); }
    }

    // This TableModel method specifies the data type for each column.  
    // We could map SQL types to Java types, but for this example, we'll just
    // convert all the returned data to strings.
    @Override
    public Class getColumnClass(int column) { return String.class; }
    
    /**
     * This is the key method of TableModel: it returns the value at each cell
     * of the table.  We use strings in this case.  If anything goes wrong, we
     * return the exception as a string, so it will be displayed in the table.
     * Note that SQL row and column numbers start at 1, but TableModel column
     * numbers start at 0.
     **/
    @Override
    public Object getValueAt(int row, int column) {
	try {
	    results.absolute(row+1);                // Go to the specified row
	    Object o = results.getObject(column+1); // Get value of the column
	    if (o == null) return null;       
	    else return o.toString();               // Convert it to a string
	} catch (SQLException e) { return e.toString(); }
    }

    // Our table isn't editable
    @Override
    public boolean isCellEditable(int row, int column) { return false; } 

    // Since its not editable, we don't need to implement these methods
    @Override
    public void setValueAt(Object value, int row, int column) {}
    
    @Override
    public void addTableModelListener(TableModelListener l) {}
    
    @Override
    public void removeTableModelListener(TableModelListener l) {}
}
