<#-- @ftlvariable name="" type="org.multibit.store.views.PublicFreemarkerView" -->
<div class="row">
  <div class="span4 logo">
    <a href="/">
      <h1>MultiBit Store<sup>alpha-4</sup></h1>
    </a>
  </div>

  <div class="span8">

    <div class="row">
      <div class="span1">&nbsp;</div>
      <div class="span2">
        <h4>Currency</h4>
        <a href="#">USD</a> |
        <a href="#"><strong>BTC</strong></a> |
        <a href="#">GBP</a> |
        <a href="#">EUR</a>
      </div>
      <div class="span2">
      <#if model.cart?? >
        <a href="/cart"><h4>Shopping Cart</h4></a>
        <a href="/cart">${model.cart.quantityTotal!"?"} item(s) - ${model.cart.currencySymbol!"?"}&nbsp;${model.cart.priceTotal!"?"}</a>
        <#if model.cart.quantityTotal != "0" >
          <a href="/checkout">Checkout</a>
        </#if>
      <#else>
        <a href="/cart"><h4>Shopping Cart</h4></a>
        <a href="/cart">0 item(s) - ${model.cart.currencySymbol!"?"}&nbsp;0.0000</a>
      </#if>
      </div>
      <div class="span3 customer_service">
        <h4>FREE delivery on ALL orders</h4>
        <h4>
          <small>Customer service: 0800 1234 567</small>
        </h4>
      </div>
    </div>
    <br/>

    <div class="row">
      <div class="links pull-right">
        <a href="/"><i class="icon-home"></i> Home</a> |
        <a href="/account"><i class="icon-user"></i> My Account</a> |
        <a href="/cart"><i class="icon-shopping-cart"></i> Shopping Cart</a> |
        <a href="/about"><i class="icon-info-sign"></i> About</a> |
        <a href="/contact"><i class="icon-envelope"></i> Contact</a>
      <#if model.user?? >
        | <a href="/account/signout"><i class="icon-off"></i> Sign Out</a>
      </#if>
      </div>
    </div>
  </div>
</div>
