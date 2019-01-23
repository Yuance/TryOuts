package Concurrency;


    /**
     *
     * 
     * @author XIEHEJUN
     * 
     */
    public class SynchronizedThread {

        class Bank {

            private int account = 100;

            public int getAccount() {
                return account;
            }

            /**
             *
             * 
             * @param money
             */
            public synchronized void save(int money) {
                account += money;
            }

            /**
             *
             * 
             * @param money
             */
            public void save1(int money) {
                synchronized (this) {
                    account += money;
                }
            }
        }

        class NewThread implements Runnable {
            private Bank bank;

            public NewThread(Bank bank) {
                this.bank = bank;
            }

            public void run() {
                for (int i = 0; i < 10; i++) {
                    // bank.save1(10);
                    bank.save(10);
                    System.out.println(i + "The Account balance is :" + bank.getAccount());
                }
            }

        }

        /**
         *
         */
        public void useThread() {
            Bank bank = new Bank();
            NewThread new_thread = new NewThread(bank);
            System.out.println("Thread1");
            Thread thread1 = new Thread(new_thread);
            thread1.start();
            System.out.println("Thread2");
            Thread thread2 = new Thread(new_thread);
            thread2.start();
        }

        public static void main(String[] args) {
            SynchronizedThread st = new SynchronizedThread();
            st.useThread();
        }

    }