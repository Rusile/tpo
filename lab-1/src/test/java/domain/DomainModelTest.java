package domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import ru.itmo.domain.Award;
import ru.itmo.domain.Catalog;
import ru.itmo.domain.Furniture;
import ru.itmo.domain.Magrathean;
import ru.itmo.domain.Planet;
import ru.itmo.domain.RealWorld;
import ru.itmo.domain.Reception;
import ru.itmo.domain.Table;

import static org.junit.jupiter.api.Assertions.*;

class DomainModelTest {

    private Catalog catalog;
    private Planet planet;
    private Reception reception;
    private Furniture plushFurniture;
    private Table glassTable;
    private Award award;
    private RealWorld realWorld;
    private Magrathean magrathean;

    @BeforeEach
    void setUp() {
        // Подготовим каталог и добавим в него одну планету
        catalog = new Catalog();
        planet = new Planet();
        catalog.addPlanet(planet);

        // Подготавливаем приемную с мебелью
        reception = new Reception();
        plushFurniture = new Furniture(true);
        glassTable = new Table(true);
        award = new Award();

        // Добавляем предметы в приемную
        reception.addFurniture(plushFurniture);
        reception.addTable(glassTable);
        reception.addAward(award);

        // Создаём реальный мир с приемной
        realWorld = new RealWorld(reception);

        // Создаём магратеянина
        magrathean = new Magrathean();
    }

    @Test
    public void testPlanetDisappears() {
        // Планета исчезает
        planet.disappear();
        // Проверяем, что планета исчезла
        assertFalse(planet.isVisible());
    }

    @Test
    public void testCatalogIsEmptyAfterDisappearing() {
        // Последняя планета исчезает
        planet.disappear();
        // Проверяем, что каталог пустой
        assertTrue(catalog.isEmpty());
    }

    @Test
    public void testReceptionHasItems() {
        // Проверяем, что приемная содержит предметы
        assertFalse(reception.isEmpty());
        assertTrue(reception.hasFurniture());
        assertTrue(reception.hasTables());
        assertTrue(reception.hasAwards());
    }

    @Test
    public void testFurnitureIsPlush() {
        // Проверяем, что мебель обита плюшем
        assertTrue(plushFurniture.isPlush());
    }

    @Test
    public void testTableIsGlass() {
        // Проверяем, что столик стеклянный
        assertTrue(glassTable.isGlass());
    }

    @Test
    public void testRealWorldHasReception() {
        // Проверяем, что в реальном мире есть приемная
        assertNotNull(realWorld.getReception());
    }

    @Test
    public void testMagratheanExists() {
        // Тест на существование объекта Магратеянина, но без контекста трудно определить,
        // что именно нужно проверить для данного класса, кроме его наличия.
        assertNotNull(magrathean);
    }
}