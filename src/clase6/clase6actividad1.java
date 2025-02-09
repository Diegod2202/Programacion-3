package clase6;

import java.util.*;

class User{
    private String nombre;
    private int id;

    public User(String nombre, int id){
        this.nombre = nombre;
        this.id = id;
    }

    public String getNombre(){
        return nombre;
    }
    public int getId(){
        return id;
    }

}


public class clase6actividad1 {
    public static void main(String[] args) {
        Map<Integer, User> users = new HashMap<>();
        Map<Integer, Set<Integer>> relations = new HashMap<>();


        users.put(1, new User("Juan", 1));
        users.put(2, new User("Rodri", 2));
        users.put(3, new User("Martin", 3));
        users.put(4, new User("Andrea", 4));
        users.put(5, new User("Diegod", 5));

        for (Integer id: users.keySet()){
            relations.put(id, new HashSet<>());
        }

        relations.get(1).add(3);
        relations.get(2).add(3);
        relations.get(3).add(5);
        relations.get(2).add(4);
        relations.get(3).add(4);
        relations.get(4).add(1);

        for (Integer id: users.keySet()){
            Set<Integer> seguidos = relations.get(id);
            if (seguidos.isEmpty()){
                System.out.println("El usuario " + users.get(id).getNombre() + " No tiene seguidores");
            }
            else{
                System.out.print("El usuario " + users.get(id).getNombre() + " Sigue a: ");
                for (int ids : seguidos) {
                    System.out.print((users.get(ids).getNombre() + " "));
                }
                System.out.println();
            }
        }
    }

}
