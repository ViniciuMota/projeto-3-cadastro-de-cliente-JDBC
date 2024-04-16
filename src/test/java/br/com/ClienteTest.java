package test.java.br.com;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;
import static org.junit.Assert.assertTrue;

import java.util.List;

import main.java.br.com.dao.jdbc.dao.ClienteDAO;
import main.java.br.com.dao.jdbc.dao.IClienteDAO;
import main.java.br.com.domen.Cliente;
import org.junit.Before;
import org.junit.Test;


public class ClienteTest {

    private IClienteDAO clienteDAO;

    @Before
    public void setUp() {
        clienteDAO = new ClienteDAO();
    }

    @Test
    public void CadastrarTest() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Lucas Martins");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(Integer.valueOf(1), countCad);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertEquals(Integer.valueOf(1), countDel);
    }

    @Test
    public void testBuscar() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Lucas Martins");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(Integer.valueOf(1), countCad);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertEquals(Integer.valueOf(1), countDel);
    }

    @Test
    public void testExcluir() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Lucas Martins");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(Integer.valueOf(1), countCad);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        Integer countDel = clienteDAO.excluir(clienteBD);
        assertEquals(Integer.valueOf(1), countDel);
    }

    @Test
    public void testBuscarTodos() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Lucas Martins");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(Integer.valueOf(1), countCad);

        Cliente clientes = new Cliente();
        clientes.setCodigo("20");
        clientes.setNome("Teste");
        Integer countCad2 = clienteDAO.cadastrar(clientes);
        assertEquals(Integer.valueOf(1), countCad2);

        List<Cliente> list = clienteDAO.buscarTodos();
        assertNotNull(list);
        assertEquals(2, list.size());

        int countDel = 0;
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
            countDel++;
        }
        assertEquals(list.size(), countDel);

        list = clienteDAO.buscarTodos();
        assertEquals(0, list.size());
    }

    @Test
    public void testAtualizar() throws Exception {
        clienteDAO = new ClienteDAO();

        Cliente cliente = new Cliente();
        cliente.setCodigo("10");
        cliente.setNome("Lucas Martins");
        Integer countCad = clienteDAO.cadastrar(cliente);
        assertEquals(Integer.valueOf(1), countCad);

        Cliente clienteBD = clienteDAO.buscar("10");
        assertNotNull(clienteBD);
        assertEquals(cliente.getCodigo(), clienteBD.getCodigo());
        assertEquals(cliente.getNome(), clienteBD.getNome());

        clienteBD.setCodigo("20");
        clienteBD.setNome("Outro nome");
        Integer countUpdate = clienteDAO.atualizar(clienteBD);
        assertEquals(Integer.valueOf(1), countUpdate);

        Cliente clienteBD1 = clienteDAO.buscar("10");
        assertNull(clienteBD1);

        Cliente clienteBD2 = clienteDAO.buscar("20");
        assertNotNull(clienteBD2);
        assertEquals(clienteBD.getId(), clienteBD2.getId());
        assertEquals(clienteBD.getCodigo(), clienteBD2.getCodigo());
        assertEquals(clienteBD.getNome(), clienteBD2.getNome());

        List<Cliente> list = clienteDAO.buscarTodos();
        for (Cliente cli : list) {
            clienteDAO.excluir(cli);
        }
    }
}