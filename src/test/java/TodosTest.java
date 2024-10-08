import org.example.*;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class TodosTest {

    @Test
    public void shouldAddThreeTasksOfDifferentType() {
        SimpleTask simpleTask = new SimpleTask(5, "Позвонить родителям");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Выкатка 3й версии приложения",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);

        Task[] expected = { simpleTask, epic, meeting };
        Task[] actual = todos.findAll();
        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearch() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Хлеб",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting1 = new Meeting(
                556,
                "Выкатка 3й версии приложения",
                "",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meeting1);

        Task[] expected = { simpleTask,epic, meeting };
        Task[] actual = todos.search("Хлеб");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearch2() {
        SimpleTask simpleTask = new SimpleTask(1, "Купить Хлеб");

        String[] subtasks = { "Молоко", "Яйца", "Хлеб" };
        Epic epic = new Epic(55, subtasks);

        Meeting meeting = new Meeting(
                555,
                "Хлеб",
                "Приложение НетоБанка",
                "Во вторник после обеда"
        );

        Meeting meeting1 = new Meeting(
                556,
                "Выкатка 3й версии приложения",
                "",
                "Во вторник после обеда"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meeting1);

        Task[] expected = { };
        Task[] actual = todos.search("Тетрадь");
        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testSearch3() {
        SimpleTask simpleTask = new SimpleTask(0, "4");

        String[] subtasks = { "1", "2", "3" };
        Epic epic = new Epic(1, subtasks);

        Meeting meeting = new Meeting(
                2,
                "1",
                "2",
                "3"
        );

        Meeting meeting1 = new Meeting(
                3,
                "1",
                "2",
                "3"
        );

        Todos todos = new Todos();

        todos.add(simpleTask);
        todos.add(epic);
        todos.add(meeting);
        todos.add(meeting1);

        Task[] expected = { simpleTask };
        Task[] actual = todos.search("4");
        Assertions.assertArrayEquals(expected, actual);

    }

}
