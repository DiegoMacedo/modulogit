package dao;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Map;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.MatchMode;
import org.hibernate.criterion.Projections;

@SuppressWarnings("unchecked")
public abstract class GenericDAO<T, ID extends Serializable> {

    private static final EntityManagerFactory factory = Persistence
            .createEntityManagerFactory("hli");
    private EntityManager entityManager = factory.createEntityManager();
    private Class<T> classePersistente;
    private Map params;

    public GenericDAO() {
        this.classePersistente = (Class) ((ParameterizedType) getClass()
                .getGenericSuperclass()).getActualTypeArguments()[0];
    }

    protected EntityManager getEntityManager() {
        return entityManager;
    }

    protected final Class<T> getClassePersistente() {
        return classePersistente;
    }

    public final void refresh(T object) {
        getEntityManager().refresh(object);
    }

    public final void flush() {
        getEntityManager().flush();
    }

    public final void clear() {
        flush();
        getEntityManager().clear();
    }

    public final T merge(T objeto) {
        EntityTransaction transacao = getEntityManager().getTransaction();
        try {
            transacao.begin();
            objeto = getEntityManager().merge(objeto);
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
            System.err.println("Erro: " + e.getMessage());
        }
        return objeto;
    }

    public final void salvar(T objeto) {
        EntityTransaction transacao = getEntityManager().getTransaction();
        try {
            transacao.begin();
            getEntityManager().persist(objeto);
            transacao.commit();
        } catch (Exception e) {
            transacao.rollback();
            System.err.println("Erro: " + e.getMessage());
        }
    }

    public final void remover(T objeto) {
        EntityTransaction transacao = getEntityManager().getTransaction();
        transacao.begin();
        getEntityManager().remove(objeto);
        transacao.commit();
    }

    public final void removerPorChave(Integer chave) {
        getEntityManager().createQuery(
                "delete from " + getClassePersistente().getName()
                + " where id = " + chave).executeUpdate();
    }

    public final T buscarPorChave(Integer chave) {
        T instance = null;
        try {
            instance = (T) getEntityManager().find(getClassePersistente(),
                    chave);
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
        return instance;
    }

    public final List<T> buscarPorExemplo(T objeto) {
        Session session = (Session) getEntityManager().getDelegate();
        Example example = criaExemplo(objeto);
        Criteria criteria = session.createCriteria(objeto.getClass()).add(
                example);

        return (List<T>) criteria.list();
    }

    public final List<T> buscaCriteria() {
        CriteriaBuilder builder = getEntityManager().getCriteriaBuilder();
        CriteriaQuery cq = builder.createQuery(getClassePersistente());
        Root rootq = cq.from(getClassePersistente());
        Query query = getEntityManager().createQuery(cq);
        return query.getResultList();
    }

    public final List<T> buscarPorExemplo(T objeto, Integer indiceInicial,
            Integer indiceFinal) {
        Example example = criaExemplo(objeto);
        Criteria criteria = criaCriteria().add(example);
        criteria.setFirstResult(indiceInicial);
        criteria.setMaxResults(indiceFinal);

        return (List<T>) criteria.list();
    }

    public final Long buscaQuantidadeTotal() {
        Criteria criteria = criaCriteria();
        criteria.setProjection(Projections.rowCount());
        return (Long) criteria.uniqueResult();
    }

    public void setEntityManager(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public void setClassePersistente(Class<T> classePersistente) {
        this.classePersistente = classePersistente;
    }

    public List<T> buscarTodos(String ordem) {
        List<T> results = null;
        try {
            Query query = getEntityManager().createQuery(
                    "from " + getClassePersistente().getName() + " Order by "
                    + ordem);
            results = query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
        return results;
    }

    public List<T> buscarTodos(Integer indiceInicial, Integer indiceFinal) {
        List<T> results = null;
        try {
            Query query = getEntityManager().createQuery(
                    "from " + getClassePersistente().getName());
            query.setFirstResult(indiceInicial);
            query.setMaxResults(indiceFinal);

            results = (List<T>) query.getResultList();
        } catch (RuntimeException re) {
            re.printStackTrace();
        }
        return results;
    }

    protected final Criteria criaCriteria() {
        Session session = (Session) getEntityManager().getDelegate();
        return session.createCriteria(getClassePersistente());
    }

    protected final Example criaExemplo(T objeto) {

        Example example = Example.create(objeto);
        example.enableLike(MatchMode.ANYWHERE);
        example.excludeZeroes();
        example.ignoreCase();

        return example;
    }

    public List<T> listPesqParam(String query, Map<String, Object> params) {
        Query q = getEntityManager().createQuery(query);
        for (String chave : params.keySet()) {
            q.setParameter(chave, params.get(chave));
        }
        return q.getResultList();
    }

    public T listPesqParamObject(String query, Map<String, Object> params) {
        Query q = getEntityManager().createQuery(query);
        for (String chave : params.keySet()) {
            q.setParameter(chave, params.get(chave));

        }
        return (T) q.getSingleResult();
    }

    public List<T> listPesq(String query) {
        Query q = getEntityManager().createQuery(query);
        return q.getResultList();
    }
}
