import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import javax.swing.JList;

public class OrderedPair<K, V> {

    private K key;
    private V value;

    public OrderedPair(K key, V value) {
	this.key = key;
	this.value = value;
    }

    public K getKey()	{ return key; }
    public V getValue() { return value; }
    
    
    
    
    public static void main(String[] args) {
    	
    	OrderedPair<String, String> op = new OrderedPair<String, String>("a", "b ");
    	OrderedPair<Integer, String> p = new OrderedPair<Integer, String>(1, "a");
    	
    	p.getKey();
    	op.getKey();
    	
    	
    	
    	
    	
    	
    	
    	
    	
    	List<String> words = Arrays.asList("kaixo","jon" ,"egun on", "Agur", "Aio");
    	
    	
    	long contador = words.stream().filter(w -> w.length() > 3).count();
    	words.stream().filter(w->w.charAt(0) == 'A').map(w->w.toUpperCase()).forEach(w->System.out.println(w));
    	
    	List<String> newWords = words.stream().filter(w->w.length()>1).map(w->w.charAt(1)+"").collect(Collectors.toList());
    	newWords.forEach(w->System.out.println(w));
    	
    	int caracteres = words.stream().sorted(Comparator.comparingInt(String::length)).findFirst().orElse(null).length();
    	
    	
    	System.out.println(caracteres);
    	
    	long chars = words.stream().mapToInt(w->w.length()).sum();    	
    	System.out.println(chars);
    	
    	
    	
    	/**
    	 * 
    	 *
    	long urgent_count = myMessage.stream().filter(m->m.getPriority == "HIGH").count();
    	
    	List<Message> myMessageLambda = myMessage.stream().filter(m->m.getPriority()=="LOW").map(m->m.setPriority("MEDIUM")).collect(Collectors.toList());
    	
    	List<Message> myMessageLambda_two = myMessage.stream().filter(m->m.getPriority()=="HIGH").map(m->m.setContent("Urgent Message")).collect(Collectors.toList());
    	
    	
    	*/
    	
    	
    	
    	
    	
    }
}