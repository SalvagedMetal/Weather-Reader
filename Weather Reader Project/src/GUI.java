import javax.swing.*;
import javax.swing.filechooser.FileFilter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.util.ArrayList;
import java.util.Collections;

    public class GUI extends JFrame {
        private JTextArea text;
        private JButton btnOpen;
        private JButton btnSave;
        private JButton dispMaxtp;
        private JButton dispRain;
        private JButton dispWdsp;
        private JButton dispSun;
        private JTextField field;
        private ArrayList<Weather> weathers;


        public static void main(String[] args) {
            SwingUtilities.invokeLater(() -> {
                GUI app = new GUI();
            });
        }

        public GUI() {
            setTitle("Weather Reader");
            setSize(500, 500);
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setLayout(null);

            //text area
            text = new JTextArea("");
            text.setEditable(false);
            text.setBounds(20, 185, 450, 200);
            add(text);

            //scrollbar
            JScrollPane scrollBar = new JScrollPane(text);
            scrollBar.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
            add(scrollBar);
            scrollBar.setBounds(13, 204, 463, 214);

            //open file button
            btnOpen = new JButton("Read Weather");
            add(btnOpen);
            btnOpen.setBounds(150, 10, 150, 20);
            BtnReadListener listener = new BtnReadListener();
            btnOpen.addActionListener(listener);

            //sort by max temp button
            dispMaxtp = new JButton("Sort temp");
            add(dispMaxtp);
            dispMaxtp.setEnabled(false);
            dispMaxtp.setBounds(150, 35, 150, 20);
            BtnSortTpListener listener2 = new BtnSortTpListener();
            dispMaxtp.addActionListener(listener2);

            //sort by rain button
            dispRain = new JButton("Sort by Rainfall");
            add(dispRain);
            dispRain.setEnabled(false);
            dispRain.setBounds(150, 60, 150, 20);
            BtnSortRnListener listener3 = new BtnSortRnListener();
            dispRain.addActionListener(listener3);

            //sort by wind speed button
            dispWdsp = new JButton("Sort by Wind Speed");
            add(dispWdsp);
            dispWdsp.setBounds(150, 85, 150, 20);
            BtnSortWdListener listener4 = new BtnSortWdListener();
            dispWdsp.addActionListener(listener4);
            dispWdsp.setEnabled(false);

            //sort by sunshine button
            dispSun = new JButton("Sort by Sunshine");
            add(dispSun);
            dispSun.setBounds(150, 110, 150, 20);
            BtnSortSnListener listener5 = new BtnSortSnListener();
            dispSun.addActionListener(listener5);
            dispSun.setEnabled(false);

            //text field
            field = new JTextField("", 20);
            add(field);
            field.setBounds(150, 135, 150, 20);
            fieldListener listener6 = new fieldListener();
            field.addActionListener(listener6);
            field.setEnabled(false);

            //save button
            btnSave = new JButton("Save");
            add(btnSave);
            btnSave.setBounds(150, 160, 150, 20);
            BtnSaveListener listener7 = new BtnSaveListener();
            btnSave.addActionListener(listener7);
            btnSave.setEnabled(false);

            setVisible(true);
        }

        private class BtnReadListener implements ActionListener {
            public void actionPerformed(ActionEvent event) {
                JFileChooser fileChooser = new JFileChooser();
                // Let the user select files and directories
                fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
                // Allow multiple selection
                fileChooser.setMultiSelectionEnabled(false);
                fileChooser.setFileFilter(new FileFilter() {
                    //@Override
                    public boolean accept(File file) {
                        if (file.isDirectory()) {
                            return true;
                        }

                        String fileName = file.getName().toLowerCase();
                        if (fileName.endsWith(".csv")) {
                            return true;
                        }
                        return false; // Reject any other files
                    }

                    public String getDescription() { //needed for file filter

                        return "Excel csv Files";
                    }
                });
                int returnValue = fileChooser.showOpenDialog(null);
                if (returnValue == JFileChooser.APPROVE_OPTION) {

                    File openedFile = fileChooser.getSelectedFile();
                    String nameFile = openedFile.getAbsolutePath();

                    try {
                        FileReader reader = new FileReader(nameFile);
                        BufferedReader br = new BufferedReader(reader);

                        //creates arraylist for weather
                        weathers = new ArrayList<>();
                        String line;
                        br.readLine(); //skips first line
                        //writes file into arraylist
                        while ((line = br.readLine()) != null) {
                            String[] split = line.split(","); //splits the strings after each ','
                            try {
                                Weather weather = new Weather(Double.parseDouble(split[0]), Double.parseDouble(split[1]), Double.parseDouble(split[2]), Double.parseDouble(split[3]), Double.parseDouble(split[4]), Double.parseDouble(split[5]), Double.parseDouble(split[6]), Double.parseDouble(split[7]), Double.parseDouble(split[8]), Double.parseDouble(split[9]), Double.parseDouble(split[10]), Double.parseDouble(split[11]));
                                weathers.add(weather);
                            } catch (Exception ae) {
                                System.out.println(" ERROR IN CSV FILE ");
                                ae.printStackTrace();
                            }
                        }
                        br.close();
                        StringBuffer sb = new StringBuffer();
                        for (Weather weather : weathers) {//displays entire arraylist
                            System.out.println(weather);
                            sb.append("\n");
                            sb.append(weather.toString());
                        }
                        text.setText(sb.toString());
                        System.out.println("\n");

                        dispMaxtp.setEnabled(true);
                        dispRain.setEnabled(true);
                        dispWdsp.setEnabled(true);
                        dispSun.setEnabled(true);
                        field.setEnabled(true);

                    } catch (IOException ex) {
                        ex.printStackTrace();
                    }
                }
            }

        }
        private class BtnSortTpListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(weathers, new TempSorter()); //sorts the array into ascending air temps
                StringBuffer sb = new StringBuffer();
                for (Weather weather : weathers) {//displays entire arraylist
                    System.out.println(weather);
                    sb.append("\n");
                    sb.append(weather.toString());
                }
                text.setText(sb.toString());
            }
        }
        private class BtnSortRnListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(weathers, new RainSorter()); //sorts the array into descending rainfall
                  StringBuffer sb = new StringBuffer();
                for (Weather weather : weathers) {//displays entire arraylist
                    System.out.println(weather);
                    sb.append("\n");
                    sb.append(weather.toString());
                }
                text.setText(sb.toString());
            }
        }

        private class BtnSortWdListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(weathers, new WindSorter()); //sorts the array into descending mean wind speed
                StringBuffer sb = new StringBuffer();
                for (Weather weather : weathers) {//displays entire arraylist
                    System.out.println(weather);
                    sb.append("\n");
                    sb.append(weather.toString());
                }
                text.setText(sb.toString());
            }
        }

        private class BtnSortSnListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                Collections.sort(weathers, new SunSorter()); //sorts the array into ascending sunshine time
                StringBuffer sb = new StringBuffer();
                for (Weather weather : weathers) {//displays entire arraylist
                    System.out.println(weather);
                    sb.append("\n");
                    sb.append(weather.toString());
                }
                text.setText(sb.toString());
            }
        }

        private class BtnSaveListener implements ActionListener {
            public void actionPerformed(ActionEvent e) {
                String fName = field.getText();
                //creates new file
                try {
                 fName += ".csv";
                 File saveFile = new File(fName);
                   if(saveFile.createNewFile()) {
                       System.out.println("File saved as: ");
                       System.out.println(fName);
                   }
                   else
                       System.out.println("File already exists, Rewriting file");
               } catch (IOException ex) {
                   ex.printStackTrace();
                   System.out.println("Error occurred trying to create file");
               }
                //writes into file
                try {
                    FileWriter writer = new FileWriter(fName);
                    StringBuffer sb = new StringBuffer();
                    sb.setLength(99765); //increases size of string buffer to accomated the long text (data loss rate of 0.0005)
                    sb.append("year,month,meant,maxtp,mintp,mnmax,mnmin,rain,gmin,wdsp,maxgt,sun"); //first line
                    for (Weather weather : weathers) {//writes entire array to file
                        System.out.println(weather);
                        sb.append("\n");
                        sb.append(weather.toFile());
                    }
                    writer.write(sb.toString());
                    System.out.println("Wrote to file");
                   // System.out.println("Capacity: " + sb.capacity()); // check the character capacity of the string buffer
                } catch (IOException ex) {
                    ex.printStackTrace();
                    System.out.println("Error occured trying to write to file");
                }
            }

        }
       private class fieldListener implements ActionListener {
           public void actionPerformed(ActionEvent e) {
               btnSave.setEnabled(true);
           }

       }
    }
