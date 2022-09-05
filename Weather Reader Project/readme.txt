Created a Weather class with getter and setters, a toString and a toFile fucntion to write to file.
Created a GUI class that contained the Main fucntion and the GUI functions.
Created JText area, 4 sort Jbuttons a file chooser button, and a file save button and an field area to name your file.
File chooser was mostely copied from the notes given and modified with a file read code from my prievious exersize.
Created a sorter for each sort needed and a sort fuction in seperate classes
The save listener includes fieldtext input to name the .csv file you want to save
The file will save back to a .csv file with the headings included

The biggest issue I had was trying to figure out why the GUI was freezing every time i included a second button. This issue took me 4 hours to resolve. Turns out when writing code to the 2nd+ buttons i wrote setEnalbed(false); instead of btnName.setEnabled(false); this disabled the GUI to disable instead of the button.
A second issue i came to was trying to get SortTp listener to display on the text area. The problem was that when reading the file it would read it fine but when sorting it, the text would disapear. The issue was text.read(br, null); and br.close(); was placed too early. so I replaced text.read with text.setText(weather.toString()); and moved br.close(); to just before creating a string buffer for the text area.
A small issue I had was trying to save the entirity of weather array. It was too big so I found out about sb.setLength() where i can set the length of the SB I want but I got pretty close with 912.5/913 line written.