# Java-Swing-MVC-OOP
<h1>Supermarket Management System (Desktop Application)</h1>

<p>This desktop application is designed to streamline supermarket management by focusing on four key roles: cashier, stock manager, officer, and admin. Each role is equipped with specific features, allowing for a highly specialized and efficient workflow.</p>

<h2>Features Overview</h2>

<h3>Admin</h3>
<ul>
  <li>Add, update, delete, and display users.</li>
  <li>Manages user accounts but operates in a separate login application from other roles.</li>
</ul>

<h3>Stock Manager</h3>
<h4>Stock Management:</h4>
<ul>
  <li>Add, update, delete, and display stock items.</li>
  <li>Advanced search and filter options for stock, including:
    <ul>
      <li>Out-of-stock</li>
      <li>Soon-to-be out-of-stock</li>
    </ul>
  </li>
  <li>Return stock management:
    <ul>
      <li>When the return count is updated, the system automatically adjusts available stock quantities.</li>
    </ul>
  </li>
</ul>

<h4>Supplier Management:</h4>
<ul>
  <li>Add, update, delete, and search suppliers.</li>
  <li>View suppliers associated with specific stock items.</li>
</ul>

<h3>Cashier</h3>
<ul>
  <li>Specially designed interface using key listeners only, making operation faster and more efficient with no need for mouse clicks.</li>
  <li>Add items to bills using item codes and quantities.</li>
  <li>Manage multiple bills at once, allowing seamless customer interactions.</li>
  <li>Remove incorrectly added items and finalize bills with balance calculations.</li>
  <li>Real-time inventory checks ensure that if multiple prices are available for an item, the system prompts the cashier to select the correct price.</li>
  <li>Upon bill completion, the system updates the inventory in real time and generates a corresponding text file for the bill.</li>
</ul>

<h3>Officer</h3>
<ul>
  <li>Generate sales reports, both daily and within a specified date range.</li>
  <li>View detailed insights into the most sold items and overall sales performance.</li>
</ul>

<h2>Technical Details</h2>
<ul>
  <li><strong>Architecture:</strong> The application follows the MVC (Model-View-Controller) design pattern for better separation of concerns.</li>
  <li><strong>Programming Principles:</strong> Built with OOP (Object-Oriented Programming) principles for maintainable, scalable code.</li>
  <li><strong>Real-time Updates:</strong> The system handles inventory and sales in real time, ensuring stock levels and records are always up-to-date.</li>
  <li><strong>Text File Generation:</strong> Each completed bill is automatically saved as a text file with relevant data for record-keeping.</li>
</ul>

<p>This project allowed me to enhance my skills in desktop application development, focusing on user interaction, inventory management, and automated tasks, which are critical in a fast-paced retail environment.</p>

