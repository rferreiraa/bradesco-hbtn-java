import java.util.*;

public class Blog {
    private Set<Post> posts;

    public Blog() {
        this.posts = new HashSet<>();
    }

    public void adicionarPostagem(Post post) {
        if (posts.contains(post)) {
            throw new IllegalArgumentException("Postagem jah existente");
        }
        posts.add(post);
    }

    // Retorna autores ordenados pelo nome (TreeSet)
    public Set<Autor> obterTodosAutores() {
        Set<Autor> autores = new TreeSet<>();
        for (Post p : posts) {
            autores.add(p.getAutor());
        }
        return autores;
    }

    // Retorna contagem por categoria mantendo a ordem do enum
    public Map<Categorias, Integer> obterContagemPorCategoria() {
        Map<Categorias, Integer> contagem = new EnumMap<>(Categorias.class);
        for (Post p : posts) {
            contagem.put(p.getCategoria(), contagem.getOrDefault(p.getCategoria(), 0) + 1);
        }
        return contagem;
    }

    public Set<Post> obterPostsPorAutor(Autor autor) {
        Set<Post> resultado = new TreeSet<>();
        for (Post p : posts) {
            if (p.getAutor().equals(autor)) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public Set<Post> obterPostsPorCategoria(Categorias categoria) {
        Set<Post> resultado = new TreeSet<>();
        for (Post p : posts) {
            if (p.getCategoria() == categoria) {
                resultado.add(p);
            }
        }
        return resultado;
    }

    public Map<Categorias, Set<Post>> obterTodosPostsPorCategorias() {
        Map<Categorias, Set<Post>> mapa = new EnumMap<>(Categorias.class);
        for (Post p : posts) {
            mapa.computeIfAbsent(p.getCategoria(), k -> new TreeSet<>()).add(p);
        }
        return mapa;
    }

    public Map<Autor, Set<Post>> obterTodosPostsPorAutor() {
        Map<Autor, Set<Post>> mapa = new TreeMap<>();
        for (Post p : posts) {
            mapa.computeIfAbsent(p.getAutor(), k -> new TreeSet<>()).add(p);
        }
        return mapa;
    }
}
