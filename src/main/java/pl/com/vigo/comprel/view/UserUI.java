package pl.com.vigo.comprel.view;

import com.vaadin.server.VaadinRequest;
import com.vaadin.spring.annotation.SpringUI;
import com.vaadin.ui.Grid;
import com.vaadin.ui.TextArea;
import com.vaadin.ui.UI;
import com.vaadin.ui.VerticalLayout;
import org.springframework.beans.factory.annotation.Autowired;
import pl.com.vigo.comprel.model.Computers;
import pl.com.vigo.comprel.model.ComputersCat;
import pl.com.vigo.comprel.model.ComputersCatDao;
import pl.com.vigo.comprel.model.ComputersDao;

import java.util.ArrayList;
import java.util.List;

@SpringUI
public class UserUI extends UI {
    @Autowired
    private ComputersDao computersDao;

    @Autowired
    private ComputersCatDao computersCatDao;

    VerticalLayout layout = new VerticalLayout();
    Grid<ComputersCat> compCatGrid;
    Grid<Computers> computersGrid;

    List<ComputersCat> comCatList = new ArrayList<>();
    List<Computers> compList = new ArrayList<>();

    @Override
    protected void init(VaadinRequest request) {
        compCatGrid = new Grid<>(ComputersCat.class);
        computersGrid = new Grid<>(Computers.class);

        compCatGrid.setItems(computersCatDao.findAll());
        compCatGrid.removeColumn("computersList");

        compCatGrid.addItemClickListener(event -> {
            ComputersCat tempCat = event.getItem();

            compList = computersDao.findByComputersCat(tempCat);
            computersGrid.setItems(compList);
        });
        layout.addComponents(compCatGrid, computersGrid);


        setContent(layout);
    }
}
