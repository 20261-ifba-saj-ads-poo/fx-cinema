package br.edu.ifba.saj.ads.poo;

import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

import br.edu.ifba.saj.ads.poo.data.Cinema;
import br.edu.ifba.saj.ads.poo.model.Filme;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Spinner;
import javafx.util.StringConverter;

public class SessaoController {

    @FXML
    private DatePicker dtHorarioDia;
    @FXML
    private Spinner<Integer> dtHorarioHora;
    @FXML
    private Spinner<Integer> dtHorarioMinuto;

    @FXML
    private ChoiceBox<Filme> slFilme;
    private Filme filmeSelecionado;

    @FXML
    public void abrirCadastarFilme(ActionEvent event) {
        try {
            App.setRoot("Filme");
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    @FXML
    private void initialize() {
        slFilme.getItems().addAll(Cinema.filmes);
        //quando um filme for selecionado na lista, vai guardar esse filme na variaval "filmeSelecionado"
        slFilme.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue != null) {
                filmeSelecionado = newValue;                
            }
        });
        //Define qual a informação do filme vai ser exibida na lista
        slFilme.setConverter(new StringConverter<Filme>() {
            @Override
            public String toString(Filme filme) {
                // Define o texto que o usuário vai ver na tela
                return filme == null ? "" : filme.getNome();
            }

            @Override
            public Filme fromString(String string) {
                // Não é necessário implementar para ChoiceBox padrão (pode retornar null)
                return null;
            }
        });
    }

    private LocalDateTime getHorarioSelecionado() {
        LocalDate date = dtHorarioDia.getValue();
        if (date == null) {
            return null; 
        }

        int hour = dtHorarioHora.getValue();
        int minute = dtHorarioMinuto.getValue();
        
        return LocalDateTime.of(date, LocalTime.of(hour, minute));
    }

    @FXML
    void salvar(ActionEvent event) {

        new Alert(AlertType.INFORMATION,String.format("Horario filme %1$td/%1$tm/%1$tY %1$tH:%1$tM ",getHorarioSelecionado())).showAndWait();
        new Alert(AlertType.INFORMATION,String.format("Nome filme %s ",getFilmeSelecionado().getNome())).showAndWait();

    }

    public Filme getFilmeSelecionado() {
        return filmeSelecionado;
    }

}
