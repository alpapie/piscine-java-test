import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

@ExtendWith(StopAfterFailureExtension.class)
class TodoListTest {
    private TodoList todoList;
    private Task task;

    @BeforeEach
    void setUp() {
        todoList = new TodoList(3);
        todoList.addTask("Go grocery shopping");
        todoList.addTask("Pay electricity bill");
        task = new Task("Test description");
    }

    @Test
    void testGetDescription() {
        assertThat(task.getDescription()).isEqualTo("Test description");
    }

    @Test
    void testSetDescription() {
        task.setDescription("New description");
        assertThat(task.getDescription()).isEqualTo("New description");
    }

    @Test
    void testGetStatus() {
        assertThat(task.getStatus()).isEqualTo(TaskStatus.NEW);
    }

    @Test
    void testSetStatus() {
        task.setStatus(TaskStatus.COMPLETED);
        assertThat(task.getStatus()).isEqualTo(TaskStatus.COMPLETED);
    }

    @Test
    void testTaskAttributesModifiers() throws NoSuchFieldException {
        java.lang.reflect.Field descriptionField = Task.class.getDeclaredField("description");
        java.lang.reflect.Field statusField = Task.class.getDeclaredField("status");

        assertThat(java.lang.reflect.Modifier.isPrivate(descriptionField.getModifiers())).isTrue();
        assertThat(java.lang.reflect.Modifier.isPrivate(statusField.getModifiers())).isTrue();
    }

    @Test
    void testDisplayTasks() {
        todoList.setStatus(0, TaskStatus.COMPLETED);
        todoList.setDescription(1, "Pay all utility bills");

        // Capture the output of displayTasks
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));

        todoList.displayTasks();

        String expectedOutput = "Tasks:\n" +
                "Go grocery shopping               | COMPLETED\n" +
                "Pay all utility bills             | NEW\n";

        assertThat(outContent.toString()).isEqualTo(expectedOutput);

        // Reset the System.out
        System.setOut(System.out);
    }

    @Test
    void testInvalidSetStatus() {
        todoList.setStatus(5, TaskStatus.COMPLETED);
        assertThat(todoList.toString()).doesNotContain("COMPLETED");
    }

    @Test
    void testInvalidSetDescription() {
        todoList.setDescription(5, "Pay all utility bills");
        assertThat(todoList.toString()).doesNotContain("Pay all utility bills");
    }

    @Test
    void testTodoListAttributesModifiers() throws NoSuchFieldException {
        java.lang.reflect.Field tasksField = TodoList.class.getDeclaredField("tasks");
        java.lang.reflect.Field capacityField = TodoList.class.getDeclaredField("capacity");
        java.lang.reflect.Field countField = TodoList.class.getDeclaredField("count");

        assertThat(java.lang.reflect.Modifier.isPrivate(tasksField.getModifiers())).isTrue();
        assertThat(java.lang.reflect.Modifier.isPrivate(capacityField.getModifiers())).isTrue();
        assertThat(java.lang.reflect.Modifier.isPrivate(countField.getModifiers())).isTrue();
    }

    @Test
    void testAddingTasksUpToCapacity() {
        todoList.addTask("Read a book");

        // Capture the output of displayTasks
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        todoList.displayTasks();
        String expectedOutput = "Tasks:\n" +
                "Go grocery shopping               | NEW\n" +
                "Pay electricity bill              | NEW\n" +
                "Read a book                       | NEW\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
        // Reset the System.out
        System.setOut(System.out);
    }

    @Test
    void testAddingTasksBeyondCapacity() {
        todoList.addTask("Read a book");
        todoList.addTask("Write a report");

        // Capture the output of displayTasks
        java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
        System.setOut(new java.io.PrintStream(outContent));
        todoList.displayTasks();
        String expectedOutput = "Tasks:\n" +
                "Go grocery shopping               | NEW\n" +
                "Pay electricity bill              | NEW\n" +
                "Read a book                       | NEW\n";
        assertThat(outContent.toString()).isEqualTo(expectedOutput);
        // Reset the System.out
        System.setOut(System.out);
    }
}
