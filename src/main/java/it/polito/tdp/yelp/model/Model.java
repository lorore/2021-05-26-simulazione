package it.polito.tdp.yelp.model;

import java.time.Year;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.jgrapht.Graph;
import org.jgrapht.Graphs;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.SimpleDirectedWeightedGraph;

import it.polito.tdp.yelp.db.YelpDao;

public class Model {
	
	
	private Graph<Business, DefaultWeightedEdge> grafo;
	private List<Business> vertici;
	private Map<String, Business> idMap;
	
	
	
	public List<String> getAllCities(){
		YelpDao dao=new YelpDao();
		return dao.getAllCities();
		
	}
	
	public String creaGrafo(String city, Year anno) {
		this.grafo=new SimpleDirectedWeightedGraph<>(DefaultWeightedEdge.class);
		YelpDao dao=new YelpDao();
		this.vertici=dao.getBusinessByCityAndYear(city, anno);
		
		idMap=new HashMap<>();
		for(Business b: vertici) {
			idMap.put(b.getBusinessId(), b);
		}
		
		Graphs.addAllVertices(this.grafo, this.vertici);
		
		List<ArcoGrafo> archi=dao.calcolaArchi(city, anno);
		for(ArcoGrafo arco:archi) {
			Graphs.addEdge(this.grafo,
					idMap.get(arco.getBusinessId1()), 
					idMap.get(arco.getBusinessId2()),
					arco.getPeso());
		}
		
		return Integer.toString( this.grafo.vertexSet().size())+" "+Integer.toString( this.grafo.edgeSet().size());
		
	}
	
	
}
