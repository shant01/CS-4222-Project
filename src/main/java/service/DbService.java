package service;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.List;
import java.math.BigDecimal;
import java.math.RoundingMode;

import tables.Album;
import tables.Musician;
import tables.Song;
import tables.Instrument;

//This class handles all the services for the database such as adding, getting, deleting data
public class DbService {
	
	//Connect to the database on postgresql
	private String url = "jdbc:postgresql://cs1.calstatela.edu/cs4222s87";

    private String username = "cs4222s87";

    private String password = "6cyjI4iM";

    private Connection connection;
    
    public DbService()
    {
        try
        {
            connection = DriverManager.getConnection( url, username, password );
        }
        catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    public void close()
    {
        if( connection != null )
        {
            try
            {
                connection.close();
            }
            catch( SQLException e )
            {
                e.printStackTrace();
            }
        }
    }
    
    //Get all the musicians from the musicians table - used for displaying
    public List<Musician> getMusicians()
    {
    	List<Musician> mus = new ArrayList<Musician>();
    	
    	try
    	{
    		Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM musicians;");
			while(rs.next()) {
				Musician m = new Musician();
				m.setSsn(rs.getInt("ssn"));
				m.setName(rs.getString("name"));
				m.setPhone(rs.getString("phone"));
				m.setAddress(rs.getString("address"));
				mus.add(m);
			}
			stmt.close();
		}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return mus;
    }
    
    //Get all the songs from the songs table - used for displaying
    public List<Song> getSongs()
    {
    	List<Song> songs = new ArrayList<Song>();
    	
    	try
    	{
    		Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM songs;");
			while(rs.next()) {
				Song s = new Song();
				s.setTitle(rs.getString("title"));
				s.setAuthor(rs.getString("author"));
				s.setMus_ssn(rs.getInt("mus_ssn"));
				s.setAlbum_id(rs.getInt("album_id"));
				songs.add(s);
			}
			stmt.close();
		}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return songs;
    }
    
    //Function that returns the total number of songs that are in any album
    public int getTotalSongs() {
    	int total = 0;
    	try
    	{
    	     CallableStatement cstmt = connection.prepareCall("{? = call total_songs()}");

    	     cstmt.registerOutParameter(1, Types.INTEGER);
    	     cstmt.execute();
    	     total = cstmt.getInt(1);

    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return total;
    }
    
    //function that returns the percentage of albums that are CD format
    public BigDecimal getCDAlbum() {
    	BigDecimal percCD = new BigDecimal(0);
    	try
    	{
    	     CallableStatement cstmt = connection.prepareCall("{? = call cd_album()}");
    	     cstmt.registerOutParameter(1, Types.DECIMAL);

    	     cstmt.execute();
    	     percCD = cstmt.getBigDecimal(1);

    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	percCD = percCD.setScale(2, RoundingMode.HALF_EVEN);
    	return percCD;
    }
    
    //Get all the albums from the albums table - used for displaying
    public List<Album> getAlbums()
    {
    	List<Album> albums = new ArrayList<Album>();
    	
    	try
    	{
    		Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM albums;");
			while(rs.next()) {
				Album a = new Album();
				a.setIdno(rs.getInt("idno"));
				a.setTitle(rs.getString("title"));
				a.setCopyright_date(rs.getDate("copyright_date"));
				a.setFormat(rs.getString("format"));
				a.setAlbum_id(rs.getInt("album_id"));
				a.setProd_ssn(rs.getInt("prod_ssn"));
				albums.add(a);
			}
			stmt.close();
		}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return albums;
    }
    
    //Get all the instruments from the instruments table - used for displaying
    public List<Instrument> getInstruments()
    {
    	List<Instrument> instruments = new ArrayList<Instrument>();
    	
    	try
    	{
    		Statement stmt = connection.createStatement();
	    	ResultSet rs = stmt.executeQuery("SELECT * FROM instruments;");
			while(rs.next()) {
				Instrument i = new Instrument();
				i.setInsid(rs.getInt("insid"));
				i.setName(rs.getString("name"));
				i.setMusic_key(rs.getString("music_key"));
				i.setMus_ssn(rs.getInt("mus_ssn"));
				instruments.add(i);
			}
			stmt.close();
		}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return instruments;
    }
    
    //adds the passed musician entry to the musicians table 
    public int addMusician(Musician entry) {
    	int ssn = entry.getSsn();
    	try
    	{
    		//insert the musician to the musicians table
    		String sql = "insert into musicians (ssn, name, phone, address) values (?, ?, ?, ?)";
    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setInt(1, ssn);
    		pstmt.setString(2, entry.getName());
    		pstmt.setString(3, entry.getPhone());
    		pstmt.setString(4, entry.getAddress());
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return ssn;
    }
    
    //adds the passed album entry to the albums table 
    public int addAlbum(Album entry) {
    	int idno = entry.getIdno();
    	try
    	{
    		//insert the album to the album table
    		String sql = "insert into albums (idno, title, copyright_date, format, album_id, prod_ssn) values (?, ?, ?, ?, ?, ?)";
    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setInt(1, idno);
    		pstmt.setString(2, entry.getTitle());
    		pstmt.setDate(3, entry.getCopyright_date());
    		pstmt.setString(4, entry.getFormat());
    		pstmt.setInt(5, entry.getAlbum_id());
    		pstmt.setInt(6, entry.getProd_ssn());
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return idno;
    }
    
    //adds the passed song entry to the songs table 
    public String addSong(Song entry) {
    	String title = entry.getTitle();
    	try
    	{
    		//insert the song to the song table
    		String sql = "insert into songs (title, author, mus_ssn, album_id) values (?, ?, ?, ?)";
    		PreparedStatement pstmt = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
    		pstmt.setString(1, title);
    		pstmt.setString(2, entry.getAuthor());
    		pstmt.setInt(3, entry.getMus_ssn());
    		if(entry.getAlbum_id() == null) {
    			pstmt.setObject(4, null);;
    		}
    		else {
    			pstmt.setInt(4, entry.getAlbum_id());
    		}
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    	return title;
    }
    
    //delete the musician based on the passed in ssn
    public void deleteMusician(int ssn) {
    	try
    	{
    		String sql = "delete from musicians where ssn = ?";
    		PreparedStatement pstmt = connection.prepareStatement( sql );
    		pstmt.setInt(1, ssn);
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    //delete the album based on the passed in album idno
    public void deleteAlbum(int idno) {
    	try
    	{
    		String sql = "delete from albums where idno = ?";
    		PreparedStatement pstmt = connection.prepareStatement( sql );
    		pstmt.setInt(1, idno);
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
    
    //delete the song based on the passed in song title
    public void deleteSong(String title) {
    	try
    	{
    		String sql = "delete from songs where title = ?";
    		PreparedStatement pstmt = connection.prepareStatement( sql );
    		pstmt.setString(1, title);
    		pstmt.executeUpdate();
    		pstmt.close();
    	}
    	catch( SQLException e )
        {
            e.printStackTrace();
        }
    }
}
