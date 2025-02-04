package Clase6;
import java.util.*;
import java.util.Objects;

public class Actividad1_RedSocial {
    private Map<Usuario, List<Usuario>> grafo;
    public Actividad1_RedSocial() {
        grafo = new HashMap<>();
    }

    public void agregarUsuario(Usuario usuario) {
        grafo.putIfAbsent(usuario, new ArrayList<>());
    }

    public void seguir(Usuario usuario, Usuario sigueA) {
        if (grafo.containsKey(usuario) && grafo.containsKey(sigueA) && !grafo.get(usuario).contains(sigueA)) {
            grafo.get(usuario).add(sigueA);
        }
    }

    public void dejarDeSeguir(Usuario usuario, Usuario dejaDeSeguirA) {
        if (grafo.containsKey(usuario) && grafo.get(usuario).contains(dejaDeSeguirA)) {
            grafo.get(usuario).remove(dejaDeSeguirA);
        }
    }

    public List<Usuario> obtenerSeguidos(Usuario usuario) {
        return grafo.getOrDefault(usuario, new ArrayList<>());
    }

    public List<Usuario> obtenerSeguidores(Usuario usuario) {
        List<Usuario> seguidores = new ArrayList<>();
        for (Map.Entry<Usuario, List<Usuario>> entry : grafo.entrySet()) {
            if (entry.getValue().contains(usuario)) {
                seguidores.add(entry.getKey());
            }
        }
        return seguidores;
    }

    public class Usuario {
        private int id;
        private String nombre;

        public Usuario(int id, String nombre) {
            this.id = id;
            this.nombre = nombre;
        }

        public int getId() {
            return id;
        }

        public String getNombre() {
            return nombre;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Usuario usuario = (Usuario) o;
            return id == usuario.id && Objects.equals(nombre, usuario.nombre);
        }

        @Override
        public int hashCode() {
            return Objects.hash(id, nombre);
        }

        @Override
        public String toString() {
            return nombre;
        }
    }
    public void main(String[] args) {
        Actividad1_RedSocial redSocial = new Actividad1_RedSocial();

        Usuario usuario0 = new Usuario(0, "Usuario0");
        Usuario usuario1 = new Usuario(1, "Usuario1");
        Usuario usuario2 = new Usuario(2, "Usuario2");
        Usuario usuario3 = new Usuario(3, "Usuario3");
        Usuario usuario4 = new Usuario(4, "Usuario4");

        redSocial.agregarUsuario(usuario0);
        redSocial.agregarUsuario(usuario1);
        redSocial.agregarUsuario(usuario2);
        redSocial.agregarUsuario(usuario3);
        redSocial.agregarUsuario(usuario4);

        redSocial.seguir(usuario0, usuario1);
        redSocial.seguir(usuario0, usuario2);
        redSocial.seguir(usuario1, usuario3);
        redSocial.seguir(usuario2, usuario3);
        redSocial.seguir(usuario3, usuario4);

        System.out.println("Usuario0 sigue a: " + redSocial.obtenerSeguidos(usuario0));
        System.out.println("Usuario3 es seguido por: " + redSocial.obtenerSeguidores(usuario3));

        redSocial.dejarDeSeguir(usuario0, usuario2);
        System.out.println("Usuario0 sigue a (después de dejar de seguir a Usuario2): " + redSocial.obtenerSeguidos(usuario0));
    }
}
