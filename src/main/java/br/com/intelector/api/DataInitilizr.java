package br.com.intelector.api;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import br.com.intelector.api.model.SegFuncionalidade;
import br.com.intelector.api.model.SegFuncionalidadeOperacao;
import br.com.intelector.api.model.SegMenu;
import br.com.intelector.api.model.SegOperacao;
import br.com.intelector.api.model.SegSubMenu;
import br.com.intelector.api.model.SegUsuario;
import br.com.intelector.api.service.impl.SegFuncionalidadeServiceImpl;
import br.com.intelector.api.service.impl.SegMenuServiceImpl;
import br.com.intelector.api.service.impl.SegOperacaoServiceImpl;
import br.com.intelector.api.service.impl.SegUserServiceImpl;

@Component
public class DataInitilizr implements ApplicationListener<ContextRefreshedEvent>{

	@Autowired
	SegUserServiceImpl userService;
	
	@Autowired
	SegOperacaoServiceImpl operacaoService;
		
	@Autowired
	SegFuncionalidadeServiceImpl funcionalidadeService;
	
	@Autowired
	SegMenuServiceImpl menuService;
	
	@Override
	public void onApplicationEvent(ContextRefreshedEvent event) {
					
		//Operações
		
		List<SegOperacao> listOperacao = new ArrayList<SegOperacao>();
		
		SegOperacao cadastrar = new SegOperacao("Cadastrar", "Cadastrar Registro", "playlist_add", "/cadastrar");
		listOperacao.add(cadastrar);
		
		SegOperacao consultar = new SegOperacao("Consultar", "Consultar Registros", "list", "/consultar");
		listOperacao.add(consultar);
		
		SegOperacao editar = new SegOperacao("Editar", "Editar Registro", "edit", null);
		listOperacao.add(editar);
		
		SegOperacao excluir = new SegOperacao("Excluir", "Excluir Registro", "delete_outline", null);
		listOperacao.add(excluir);

		SegOperacao inativar = new SegOperacao("Inativar", "Inativar Registro", "", null);
		listOperacao.add(inativar);
		
		SegOperacao buscar = new SegOperacao("Buscar", "Buscar Registro", "zoom_in", null);
		listOperacao.add(buscar);
		
		SegOperacao gerarRelatorioXls = new SegOperacao("Relatório XLS", "Relatório XLS", "", null);
		listOperacao.add(gerarRelatorioXls);
		
		SegOperacao gerarRelatorioPdf = new SegOperacao("Relatório PDF", "Relatório PDF", "", null);
		listOperacao.add(gerarRelatorioPdf);
		
		operacaoService.saveAll(listOperacao);

		//Funcionalidades x Operações
		
		List<SegFuncionalidade> listFuncionalidade = new ArrayList<SegFuncionalidade>();
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoOperacao = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadeOperacao = new SegFuncionalidade("Operação", "Gerenciar Operações", "/seg-operacoes", listFuncionalidadeOperacaoOperacao);
		SegFuncionalidadeOperacao operacaoCadastrar = new SegFuncionalidadeOperacao(funcionalidadeOperacao, cadastrar, true, 2);
		SegFuncionalidadeOperacao operacaoBuscar = new SegFuncionalidadeOperacao(funcionalidadeOperacao, buscar, false, 3);
		SegFuncionalidadeOperacao operacaoEditar = new SegFuncionalidadeOperacao(funcionalidadeOperacao, editar, false, 4);
		SegFuncionalidadeOperacao operacaoExcluir = new SegFuncionalidadeOperacao(funcionalidadeOperacao, excluir, false, 5);
		SegFuncionalidadeOperacao operacaoConsultar= new SegFuncionalidadeOperacao(funcionalidadeOperacao, consultar, true, 1);
		listFuncionalidadeOperacaoOperacao.add(operacaoCadastrar);
		listFuncionalidadeOperacaoOperacao.add(operacaoBuscar);
		listFuncionalidadeOperacaoOperacao.add(operacaoEditar);
		listFuncionalidadeOperacaoOperacao.add(operacaoExcluir);
		listFuncionalidadeOperacaoOperacao.add(operacaoConsultar);
		
		listFuncionalidade.add(funcionalidadeOperacao);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoFuncionalidade = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadeFuncionalidade = new SegFuncionalidade("Funcionalidade", "Gerenciar Funcionalidade", "/seg-funcionalidades", listFuncionalidadeOperacaoFuncionalidade);
		SegFuncionalidadeOperacao funcionalidadeCadastrar = new SegFuncionalidadeOperacao(funcionalidadeFuncionalidade, cadastrar, true, 2);
		SegFuncionalidadeOperacao funcionalidadeEditar = new SegFuncionalidadeOperacao(funcionalidadeFuncionalidade, editar, false, 3);
		SegFuncionalidadeOperacao funcionalidadeExcluir = new SegFuncionalidadeOperacao(funcionalidadeFuncionalidade, excluir, false, 4);
		listFuncionalidadeOperacaoOperacao.add(funcionalidadeCadastrar);
		listFuncionalidadeOperacaoOperacao.add(funcionalidadeEditar);
		listFuncionalidadeOperacaoOperacao.add(funcionalidadeExcluir);
		
		listFuncionalidade.add(funcionalidadeFuncionalidade);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoMenu = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadeMenu = new SegFuncionalidade("Menu", "Gerenciar Menu", "/seg-menus", listFuncionalidadeOperacaoMenu);
		SegFuncionalidadeOperacao menuCadastrar = new SegFuncionalidadeOperacao(funcionalidadeMenu, cadastrar, true, 2);
		SegFuncionalidadeOperacao menuEditar = new SegFuncionalidadeOperacao(funcionalidadeMenu, editar, false, 3);
		SegFuncionalidadeOperacao menuExcluir = new SegFuncionalidadeOperacao(funcionalidadeMenu, excluir, false, 4);
		listFuncionalidadeOperacaoMenu.add(menuCadastrar);
		listFuncionalidadeOperacaoMenu.add(menuEditar);
		listFuncionalidadeOperacaoMenu.add(menuExcluir);
		
		listFuncionalidade.add(funcionalidadeMenu);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoSubMenu = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadeSubMenu = new SegFuncionalidade("SubMenu", "Gerenciar SubMenu", "/seg-submenus", listFuncionalidadeOperacaoSubMenu);
		SegFuncionalidadeOperacao subMenuCadastrar = new SegFuncionalidadeOperacao(funcionalidadeSubMenu, cadastrar, true, 2);
		SegFuncionalidadeOperacao subMenuEditar = new SegFuncionalidadeOperacao(funcionalidadeSubMenu, editar, false, 3);
		SegFuncionalidadeOperacao subMenuExcluir = new SegFuncionalidadeOperacao(funcionalidadeSubMenu, excluir, false, 4);
		listFuncionalidadeOperacaoSubMenu.add(subMenuCadastrar);
		listFuncionalidadeOperacaoSubMenu.add(subMenuEditar);
		listFuncionalidadeOperacaoSubMenu.add(subMenuExcluir);
		
		listFuncionalidade.add(funcionalidadeSubMenu);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoPerfil = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadePerfil = new SegFuncionalidade("Perfil", "Gerenciar Perfil", "/seg-perfis", listFuncionalidadeOperacaoPerfil);
		SegFuncionalidadeOperacao perfilCadastrar = new SegFuncionalidadeOperacao(funcionalidadePerfil, cadastrar, true, 2);
		SegFuncionalidadeOperacao perfilEditar = new SegFuncionalidadeOperacao(funcionalidadePerfil, editar, false, 3);
		SegFuncionalidadeOperacao perfilExcluir = new SegFuncionalidadeOperacao(funcionalidadePerfil, excluir, false, 4);
		listFuncionalidadeOperacaoPerfil.add(perfilCadastrar);
		listFuncionalidadeOperacaoPerfil.add(perfilEditar);
		listFuncionalidadeOperacaoPerfil.add(perfilExcluir);
		
		listFuncionalidade.add(funcionalidadePerfil);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoPermissao = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadePermissao = new SegFuncionalidade("Permissão", "Gerenciar Permissão", "/seg-permissoes", listFuncionalidadeOperacaoPermissao);
		SegFuncionalidadeOperacao permissaoCadastrar = new SegFuncionalidadeOperacao(funcionalidadePermissao, cadastrar, true, 2);
		SegFuncionalidadeOperacao permissaoEditar = new SegFuncionalidadeOperacao(funcionalidadePermissao, editar, false, 3);
		SegFuncionalidadeOperacao permissaoExcluir = new SegFuncionalidadeOperacao(funcionalidadePermissao, excluir, false, 4);
		listFuncionalidadeOperacaoPermissao.add(permissaoCadastrar);
		listFuncionalidadeOperacaoPermissao.add(permissaoEditar);
		listFuncionalidadeOperacaoPermissao.add(permissaoExcluir);
		
		listFuncionalidade.add(funcionalidadePermissao);
		
		List<SegFuncionalidadeOperacao> listFuncionalidadeOperacaoUsuario = new ArrayList<SegFuncionalidadeOperacao>();
		
		SegFuncionalidade funcionalidadeUsuario = new SegFuncionalidade("Usuário", "Gerenciar Usuário", "/seg-usuarios", listFuncionalidadeOperacaoUsuario);
		SegFuncionalidadeOperacao usuarioCadastrar = new SegFuncionalidadeOperacao(funcionalidadeUsuario, cadastrar, true, 2);
		SegFuncionalidadeOperacao usuarioEditar = new SegFuncionalidadeOperacao(funcionalidadeUsuario, editar, true, 2);
		SegFuncionalidadeOperacao usuarioExcluir = new SegFuncionalidadeOperacao(funcionalidadeUsuario, excluir, true, 2);
		listFuncionalidadeOperacaoUsuario.add(usuarioCadastrar);
		listFuncionalidadeOperacaoUsuario.add(usuarioEditar);
		listFuncionalidadeOperacaoUsuario.add(usuarioExcluir);
		
		listFuncionalidade.add(funcionalidadeUsuario);
				
		funcionalidadeService.saveAll(listFuncionalidade);
		
		//Menu x SubMenu
		List<SegSubMenu> listSubMenu = new ArrayList<SegSubMenu>();
		
		SegMenu menuSeguranca = new SegMenu("Segurança", "lock", 1, listSubMenu);
		
		SegSubMenu subMenuOperacao = new SegSubMenu(menuSeguranca, funcionalidadeOperacao, "build", 1);
		listSubMenu.add(subMenuOperacao);
		
		SegSubMenu subMenufuncionalidade = new SegSubMenu(menuSeguranca, funcionalidadeFuncionalidade, "web", 2);
		listSubMenu.add(subMenufuncionalidade);
		
		SegSubMenu subMenuMenu = new SegSubMenu(menuSeguranca, funcionalidadeMenu, "format_list_numbered", 3);
		listSubMenu.add(subMenuMenu);
		
		SegSubMenu subMenuPerfil = new SegSubMenu(menuSeguranca, funcionalidadePerfil, "how_to_reg", 4);
		listSubMenu.add(subMenuPerfil);
		
		SegSubMenu subMenuPermissao = new SegSubMenu(menuSeguranca, funcionalidadePermissao, "touch_app", 5);
		listSubMenu.add(subMenuPermissao);
		
		SegSubMenu subMenuUsuario = new SegSubMenu(menuSeguranca, funcionalidadeUsuario, "account_circle", 6);
		listSubMenu.add(subMenuUsuario);
		
		menuService.save(menuSeguranca);
		
		//Usuários
		List<SegUsuario> listUsuario = new ArrayList<SegUsuario>();
				
		SegUsuario usuarioThiago = new SegUsuario("Thiago", "admin", "thiago@gmail.com", "123456");
		listUsuario.add(usuarioThiago);
		SegUsuario usuarioBrenda = new SegUsuario("Brenda", "brenda", "brenda@gmail.com", "123456");
		listUsuario.add(usuarioBrenda);
				
		userService.saveAll(listUsuario);	
			
	}
		

}
