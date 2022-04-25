public class Main {

    public static void main(String[] args) throws IllegalStateException {
        Person mom = new PersonBuilder()
                .setName("Анна")
                .setSurname("Осипенко")
                .setAge(22)
                .setAddress("Москва")
                .build();
        mom.happyBirthday();

        Person son = mom.newChildBuilder()
                .setName("Антошка")
                .build();
        System.out.println("У " + mom + " есть сын, " + son);

        try {
            // Не хватает обязательных полей
            new PersonBuilder().build();
        } catch (IllegalStateException e) {
            e.printStackTrace();
        }

        try {
            // Возраст недопустимый
            new PersonBuilder().setAge(-100).build();
        } catch (IllegalArgumentException e) {
            e.printStackTrace();
        }
    }
}