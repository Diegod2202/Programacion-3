import java.util.*;

class Usuario {
    private String nombre;
    private List<Usuario> seguidores;

    public Usuario(String nombre) {
        this.nombre = nombre;
        this.seguidores = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public List<Usuario> getSeguidores() {
        return seguidores;
    }

    public void seguir(Usuario usuario) {
        if (!seguidores.contains(usuario)) {
            seguidores.add(usuario);
        }
    }

    public void dejarDeSeguir(Usuario usuario) {
        seguidores.remove(usuario);
    }
}

class RedSocial {
    private Map<String, Usuario> usuarios;

    public RedSocial() {
        this.usuarios = new HashMap<>();
    }

    public void agregarUsuario(String nombre) {
        if (!usuarios.containsKey(nombre)) {
            usuarios.put(nombre, new Usuario(nombre));
        }
    }

    public void seguir(String seguidor, String seguido) {
        Usuario usuarioSeguidor = usuarios.get(seguidor);
        Usuario usuarioSeguido = usuarios.get(seguido);
        if (usuarioSeguidor != null && usuarioSeguido != null) {
            usuarioSeguidor.seguir(usuarioSeguido);
        }
    }

    public void dejarDeSeguir(String seguidor, String seguido) {
        Usuario usuarioSeguidor = usuarios.get(seguidor);
        Usuario usuarioSeguido = usuarios.get(seguido);
        if (usuarioSeguidor != null && usuarioSeguido != null) {
            usuarioSeguidor.dejarDeSeguir(usuarioSeguido);
        }
    }

    public List<Usuario> obtenerSeguidores(String nombre) {
        Usuario usuario = usuarios.get(nombre);
        if (usuario != null) {
            return usuario.getSeguidores();
        }
        return Collections.emptyList();
    }

    public static void main(String[] args) {
        RedSocial redSocial = new RedSocial();
        redSocial.agregarUsuario("Alice");
        redSocial.agregarUsuario("Bob");
        redSocial.agregarUsuario("Charlie");

        redSocial.seguir("Alice", "Bob");
        redSocial.seguir("Alice", "Charlie");
        redSocial.seguir("Bob", "Charlie");

        System.out.println("Seguidores de Bob: ");
        for (Usuario seguidor : redSocial.obtenerSeguidores("Bob")) {
            System.out.println(seguidor.getNombre());
        }

        System.out.println("Seguidores de Charlie: ");
        for (Usuario seguidor : redSocial.obtenerSeguidores("Charlie")) {
            System.out.println(seguidor.getNombre());
        }
    }
}