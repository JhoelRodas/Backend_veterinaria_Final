"use strict";(self.webpackChunkfury=self.webpackChunkfury||[]).push([[42],{66042:(q,b,n)=>{n.r(b),n.d(b,{HistorialClinicoModule:()=>W});var h=n(60177),u=n(18498),l=n(9159),R=n(17114),t=n(17705),v=n(97405),M=n(34006),F=n(74061),N=n(75063),d=n(88834),y=n(82765),x=n(99213),p=n(59115),H=n(96695),C=n(2042),k=n(43655),j=n(53007),D=n(15551);function G(i,s){1&i&&(t.j41(0,"th",15)(1,"mat-checkbox",16),t.bIt("click",function(e){return e.stopPropagation()}),t.k0s()())}function $(i,s){1&i&&(t.j41(0,"td",17)(1,"mat-checkbox",16),t.bIt("click",function(e){return e.stopPropagation()}),t.k0s()())}function T(i,s){if(1&i&&(t.j41(0,"th",22),t.EFF(1),t.k0s()),2&i){const o=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o.name,"")}}function S(i,s){if(1&i&&(t.j41(0,"td",23),t.EFF(1),t.k0s()),2&i){const o=s.$implicit,e=t.XpG(2).$implicit;t.R7$(1),t.SpI(" ",o[e.property]," ")}}function P(i,s){if(1&i&&(t.qex(0,19),t.DNE(1,T,2,1,"th",20),t.DNE(2,S,2,1,"td",21),t.bVm()),2&i){const o=t.XpG().$implicit;t.Y8G("matColumnDef",o.property)}}function _(i,s){if(1&i&&(t.qex(0),t.DNE(1,P,3,1,"ng-container",18),t.bVm()),2&i){const o=s.$implicit;t.R7$(1),t.Y8G("ngIf",o.isModelProperty)}}function V(i,s){1&i&&t.nrm(0,"th",24)}function X(i,s){if(1&i){const o=t.RV6();t.j41(0,"td",17)(1,"button",25),t.bIt("click",function(a){return a.stopPropagation()}),t.j41(2,"mat-icon"),t.EFF(3,"more_horiz"),t.k0s()(),t.j41(4,"mat-menu",26,27)(6,"button",28),t.bIt("click",function(){const c=t.eBV(o).$implicit,m=t.XpG();return t.Njj(m.updateHistorial(c))}),t.j41(7,"span"),t.EFF(8,"Ver Historial"),t.k0s()(),t.j41(9,"button",28),t.bIt("click",function(){const c=t.eBV(o).$implicit,m=t.XpG();return t.Njj(m.deleteEstante(c))}),t.j41(10,"span"),t.EFF(11,"Delete"),t.k0s()()()()}if(2&i){const o=t.sdS(5);t.R7$(1),t.Y8G("matMenuTriggerFor",o)}}function Y(i,s){1&i&&t.nrm(0,"tr",29)}function w(i,s){if(1&i){const o=t.RV6();t.j41(0,"tr",30),t.bIt("click",function(){const c=t.eBV(o).$implicit,m=t.XpG();return t.Njj(m.updateHistorial(c))}),t.k0s()}}const z=function(){return["Historial Clinico"]},O=function(){return[]};let U=(()=>{class i{ngOnInit(){this.getHistoriales()}get visibleColumns(){return this.columns.filter(o=>o.visible).map(o=>o.property)}constructor(o,e,a){this.apiClient=o,this.dialog=e,this.router=a,this.dataSource=new l.I6([]),this.columns=[{name:"ID",property:"id",visible:!0,isModelProperty:!0},{name:"Due\xf1o",property:"duenio",visible:!0,isModelProperty:!0},{name:"Mascota",property:"mascota",visible:!0,isModelProperty:!0},{name:"Actions",property:"actions",visible:!0}],this.pageSize=10}getHistoriales(){this.apiClient.getRequest("/api/historial").subscribe({next:o=>{this.dataSource.data=o,console.log(o)},error:o=>{console.error(o)}})}createEstante(){console.info("Abre dialogo de creacion"),this.dialog.open(R.X,{width:"400px"}).afterClosed().subscribe(o=>{o?(console.info("Al cerrar",o),this.apiClient.postRequest("/api/estante",o).subscribe({next:e=>{console.info("OK",e),this.getHistoriales()},error:e=>{console.error("error",e)}}),console.info("Fin api call")):console.info("Cancelado"),console.info("Fin Metodo")})}updateHistorial(o){console.info(o),this.router.navigate([`ventas/historialClinico/historial-detalles/${o.id}`])}deleteEstante(o){console.info("deleteServicio",o),this.apiClient.deleteRequest(o.id,"/api/estante").subscribe({next:e=>{this.getHistoriales()},error:e=>{console.info(e)}})}onFilterChange(o){console.info(event),this.dataSource&&(o=(o=o.trim()).toLowerCase(),this.dataSource.filter=o)}static{this.\u0275fac=function(e){return new(e||i)(t.rXU(v.f),t.rXU(M.bZ),t.rXU(u.Ix))}}static{this.\u0275cmp=t.VBU({type:i,selectors:[["fury-historial-clinico"]],decls:20,vars:9,consts:[["mode","card"],["current","Historial Clinico",3,"crumbs"],["name","Historiales Clinicos",3,"columns","filterChange"],[1,"actions"],["type","button","mat-mini-fab","","color","primary",1,"create",3,"click"],["mat-table","","matSort","",3,"dataSource"],["matColumnDef","checkbox"],["class","actions-cell","mat-header-cell","",4,"matHeaderCellDef"],["class","actions-cell","mat-cell","",4,"matCellDef"],[4,"ngFor","ngForOf"],["matColumnDef","actions"],["class","actions-cell","mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-header-row","",4,"matHeaderRowDef"],["class","clickable route-animations-elements","mat-row","",3,"click",4,"matRowDef","matRowDefColumns"],[1,"paginator",3,"pageSize"],["mat-header-cell","",1,"actions-cell"],["color","primary",3,"click"],["mat-cell","",1,"actions-cell"],[3,"matColumnDef",4,"ngIf"],[3,"matColumnDef"],["mat-header-cell","","mat-sort-header","",4,"matHeaderCellDef"],["mat-cell","",4,"matCellDef"],["mat-header-cell","","mat-sort-header",""],["mat-cell",""],["mat-header-cell","","mat-sort-header","",1,"actions-cell"],["type","button","mat-icon-button","",3,"matMenuTriggerFor","click"],["yPosition","below","xPosition","before"],["actionsMenu","matMenu"],["mat-menu-item","",3,"click"],["mat-header-row",""],["mat-row","",1,"clickable","route-animations-elements",3,"click"]],template:function(e,a){1&e&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"fury-list",2),t.bIt("filterChange",function(m){return a.onFilterChange(m)}),t.j41(5,"div",3)(6,"button",4),t.bIt("click",function(){return a.createEstante()}),t.j41(7,"mat-icon"),t.EFF(8,"add"),t.k0s()()(),t.j41(9,"table",5),t.qex(10,6),t.DNE(11,G,2,0,"th",7),t.DNE(12,$,2,0,"td",8),t.bVm(),t.DNE(13,_,2,1,"ng-container",9),t.qex(14,10),t.DNE(15,V,1,0,"th",11),t.DNE(16,X,12,1,"td",8),t.bVm(),t.DNE(17,Y,1,0,"tr",12),t.DNE(18,w,1,0,"tr",13),t.k0s(),t.nrm(19,"mat-paginator",14),t.k0s()()()),2&e&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(7,z)),t.R7$(2),t.Y8G("columns",t.lJ4(8,O)),t.R7$(5),t.Y8G("dataSource",a.dataSource),t.R7$(4),t.Y8G("ngForOf",a.columns),t.R7$(4),t.Y8G("matHeaderRowDef",a.visibleColumns),t.R7$(1),t.Y8G("matRowDefColumns",a.visibleColumns),t.R7$(1),t.Y8G("pageSize",a.pageSize))},dependencies:[h.Sq,h.bT,F.m,N.s,d.iY,d.$0,y.So,x.An,p.kk,p.fb,p.Cp,H.iy,C.B4,C.aE,l.Zl,l.tL,l.ji,l.cC,l.YV,l.iL,l.KS,l.$R,l.YZ,l.NB,k.T,j.M,D.M]})}}return i})();var r=n(89417),E=n(21626),g=n(86467),f=n(52920),I=n(99631);const B=function(){return["Historial Clinico"]},A=[{path:"",component:U},{path:"historial-detalles/:idHistorial",component:(()=>{class i{constructor(o,e,a,c){this.apiClient=o,this.activatedRoute=e,this.router=a,this.http=c,this.form=new r.J3({id:new r.hs({value:"",disabled:!0}),nombreMascota:new r.hs({value:"",disabled:!0}),especie:new r.hs({value:"",disabled:!0}),raza:new r.hs({value:"",disabled:!0}),sexo:new r.hs({value:"",disabled:!0}),nombrePropietario:new r.hs({value:"",disabled:!0}),estadoFc:new r.hs(""),estadoFr:new r.hs(""),mucosa:new r.hs(""),apetito:new r.hs(""),hidratacion:new r.hs(""),estadoGeneral:new r.hs("")})}ngOnInit(){this.activatedRoute.paramMap.subscribe(o=>{const e=o.get("idHistorial");console.log(e);const a=(new E.Nl).set("id",e.toString());console.info(a),this.getHistorial(a)})}getHistorial(o){console.info("entro al metodo",o),this.apiClient.getRequest("/api/historial/get",o).subscribe({next:e=>{console.info(e),this.form.patchValue({id:e.id,nombreMascota:e.mascota,especie:e.especie,raza:e.raza,sexo:e.sexo,nombrePropietario:e.duenio,estadoFc:e.estadoFc,estadoFr:e.estadoFr,mucosa:e.mucosa,apetito:e.apetito,hidratacion:e.hidratacion,estadoGeneral:e.estadoGeneral}),console.info(this.form.value)},error:e=>{console.error("Error al obtener los datos:",e)}})}guardarDetallesDeHistorial(){const o=this.form.getRawValue();console.log("historialData",o),this.apiClient.putRequest("/api/historial",o.id,o).subscribe({next:e=>{this.router.navigate(["ventas/historialClinico"])},error:e=>{console.info(e)}})}static{this.\u0275fac=function(e){return new(e||i)(t.rXU(v.f),t.rXU(u.nX),t.rXU(u.Ix),t.rXU(E.Qq))}}static{this.\u0275cmp=t.VBU({type:i,selectors:[["fury-historial-detalles"]],decls:86,vars:3,consts:[["mode","simple"],["current","Historial Clinico",3,"crumbs"],["fxLayout","column wrap",3,"formGroup"],["fxFlex","100"],["fxLayout","row wrap"],["fxFlex","100","fxFlex.gt-xs","50"],["appearance","fill","fxFlex",""],["matInput","","formControlName","id","readonly",""],["matInput","","formControlName","nombreMascota","readonly",""],["matInput","","formControlName","especie","readonly",""],["matInput","","formControlName","raza","readonly",""],["matInput","","formControlName","sexo","readonly",""],["matInput","","formControlName","nombrePropietario","readonly",""],["matInput","","formControlName","estadoFc"],["matInput","","formControlName","estadoFr"],["matInput","","formControlName","mucosa"],["matInput","","formControlName","apetito"],["matInput","","formControlName","hidratacion"],["matInput","","formControlName","estadoGeneral"],["fxLayoutAlign","end",2,"margin-top","20px"],["mat-raised-button","","color","primary",3,"click"],["fxLayoutGap","20px","fxLayoutAlign","center center"]],template:function(e,a){1&e&&(t.j41(0,"fury-page-layout",0)(1,"fury-page-layout-header"),t.nrm(2,"fury-breadcrumbs",1),t.k0s(),t.j41(3,"fury-page-layout-content")(4,"div",2)(5,"div",3)(6,"div",4)(7,"div",5)(8,"div",4)(9,"div",3)(10,"h3"),t.EFF(11,"Informacion de la Mascota"),t.k0s()(),t.j41(12,"div",3)(13,"mat-form-field",6)(14,"mat-label"),t.EFF(15,"ID Historial"),t.k0s(),t.nrm(16,"input",7),t.k0s()(),t.j41(17,"div",3)(18,"mat-form-field",6)(19,"mat-label"),t.EFF(20,"Nombre"),t.k0s(),t.nrm(21,"input",8),t.k0s()(),t.j41(22,"div",3)(23,"mat-form-field",6)(24,"mat-label"),t.EFF(25,"Especie"),t.k0s(),t.nrm(26,"input",9),t.k0s()(),t.j41(27,"div",3)(28,"mat-form-field",6)(29,"mat-label"),t.EFF(30,"Raza"),t.k0s(),t.nrm(31,"input",10),t.k0s()(),t.j41(32,"div",3)(33,"mat-form-field",6)(34,"mat-label"),t.EFF(35,"Sexo"),t.k0s(),t.nrm(36,"input",11),t.k0s()()()(),t.j41(37,"div",5)(38,"div",4)(39,"div",3)(40,"h3"),t.EFF(41,"Informaci\xf3n del Propietario"),t.k0s()(),t.j41(42,"div",3)(43,"mat-form-field",6)(44,"mat-label"),t.EFF(45,"Nombre del Propietario"),t.k0s(),t.nrm(46,"input",12),t.k0s()()()()()(),t.j41(47,"div",3)(48,"div",4)(49,"div",3)(50,"h3"),t.EFF(51,"Datos del Historial"),t.k0s()(),t.j41(52,"div",3)(53,"mat-form-field",6)(54,"mat-label"),t.EFF(55,"(Frecuencia Cardiaca)"),t.k0s(),t.nrm(56,"input",13),t.k0s()(),t.j41(57,"div",3)(58,"mat-form-field",6)(59,"mat-label"),t.EFF(60,"(Frecuencia Respiratoria)"),t.k0s(),t.nrm(61,"input",14),t.k0s()(),t.j41(62,"div",3)(63,"mat-form-field",6)(64,"mat-label"),t.EFF(65,"(Mucosa)"),t.k0s(),t.nrm(66,"input",15),t.k0s()(),t.j41(67,"div",3)(68,"mat-form-field",6)(69,"mat-label"),t.EFF(70,"(Apetito)"),t.k0s(),t.nrm(71,"input",16),t.k0s()(),t.j41(72,"div",3)(73,"mat-form-field",6)(74,"mat-label"),t.EFF(75,"(Hidratacion)"),t.k0s(),t.nrm(76,"input",17),t.k0s()(),t.j41(77,"div",3)(78,"mat-form-field",6)(79,"mat-label"),t.EFF(80,"(Estado general)"),t.k0s(),t.nrm(81,"input",18),t.k0s()()()(),t.j41(82,"div",19)(83,"button",20),t.bIt("click",function(){return a.guardarDetallesDeHistorial()}),t.EFF(84,"Guardar Cambios"),t.k0s()()(),t.nrm(85,"div",21),t.k0s()()),2&e&&(t.R7$(2),t.Y8G("crumbs",t.lJ4(2,B)),t.R7$(2),t.Y8G("formGroup",a.form))},dependencies:[F.m,d.$z,k.T,j.M,D.M,r.me,r.BC,r.cb,r.j4,r.JD,g.rl,g.nJ,f.DJ,f.BO,f.sA,f.UI,I.fg],styles:[".container[_ngcontent-%COMP%]{max-width:800px;padding:16px;box-sizing:border-box}.form-container[_ngcontent-%COMP%]{width:100%;max-width:600px;margin:auto}h2[_ngcontent-%COMP%]{text-align:center;font-size:1.6rem;color:#333;margin-bottom:16px}.readonly-field[_ngcontent-%COMP%]   input[readonly][_ngcontent-%COMP%]{background-color:#f0f0f0;color:#333;border-radius:4px}.readonly-field[_ngcontent-%COMP%]   .mat-form-field-flex[_ngcontent-%COMP%]{border:1px solid #d0d0d0;padding:4px 8px}"]})}}return i})()}];let L=(()=>{class i{static{this.\u0275fac=function(e){return new(e||i)}}static{this.\u0275mod=t.$C({type:i})}static{this.\u0275inj=t.G2t({imports:[u.iI.forChild(A),u.iI]})}}return i})();var J=n(3632),Z=n(91398),K=n(49320),Q=n(26924);let W=(()=>{class i{static{this.\u0275fac=function(e){return new(e||i)}}static{this.\u0275mod=t.$C({type:i})}static{this.\u0275inj=t.G2t({imports:[h.MD,L,J.V,Z.H,d.Hl,y.g7,x.m_,p.Cn,H.Ou,C.NQ,l.tP,K.S,r.X1,g.RG,Q.YF,I.fS]})}}return i})()}}]);