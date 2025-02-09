package clase6;

import java.util.*;

class Userr{
    private String nombre;
    private int Id;

    public Userr(String nombre, int Id){
        this.nombre = nombre;
        this.Id = Id;
    }

    public String getNombre(){
        return nombre;
    }
    public int getId() {
        return Id;
    }
}

class followers{
    Map<Userr, Set<Userr>> relaciones = new HashMap();

    public followers(){
        this.relaciones.put(null, new HashSet());
    }

    public void newUser(Userr user){
        relaciones.putIfAbsent(user, new HashSet());
    }

    public void follow(Userr follower,Userr followed){
        relaciones.putIfAbsent(follower, new HashSet<>());
        relaciones.putIfAbsent(followed, new HashSet<>());
        relaciones.get(follower).add(followed);

    }

    public void unfollow(Userr follower,Userr followed){
        if(relaciones.get(follower).contains(followed)){
        relaciones.get(follower).remove(followed);
    }
    }

    public void followlist(Userr usuario){
        if(!relaciones.containsKey(usuario) || relaciones.get(usuario).isEmpty()){
            System.out.print("El usuario" + usuario.getNombre() + " no sigue ni al loro sapiens");
        }
        System.out.println("El usuario" + usuario.getNombre() + " sigue a: ");
        for (Userr seguido : relaciones.get(usuario)){
            System.out.print(seguido.getNombre() + " ");
        }
        System.out.println();
    }

    public void followerList(Userr usuario){
        List<Userr> seguidores = new ArrayList<>();

    }
}

public class clase6actividad1_2 {
    public static void main(String[] args) {
    }
}
