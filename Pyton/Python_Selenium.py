import pytest
from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.common.action_chains import ActionChains
from selenium.webdriver.support import expected_conditions as EC
from selenium.webdriver.support.ui import WebDriverWait

@pytest.fixture(scope="module")
def browser():
    # Initialize Chrome WebDriver
    driver = webdriver.Chrome()
    # Wait for elements to be located
    driver.implicitly_wait(10)
    yield driver
    # Close the browser after the test
    driver.quit()

def test_navigation(browser):
    # Open the website
    browser.get("https://www.automationanywhere.com/")
    
    # Locate the "Products" menu and hover over it
    products_menu = browser.find_element(By.XPATH, '//*[@id="topNavbar"]/div/div/div[2]/ul/li[2]/a')
    ActionChains(browser).move_to_element(products_menu).perform()
    
    # Click on "Process Discovery" under the "Products" menu
    process_discovery_link = browser.find_element(By.XPATH, '//*[@id="topNavbar"]/div/div/div[2]/ul/li[2]/div/div/div/div/div[3]/ul/li[1]/ul/li/a')
    process_discovery_link.click()
    
    # Wait for the page to load
    WebDriverWait(browser, 10).until(EC.url_to_be("https://www.automationanywhere.com/products/process-discovery"))
    
    # Verify that the URL matches the expected URL
    assert browser.current_url == "https://www.automationanywhere.com/products/process-discovery"
