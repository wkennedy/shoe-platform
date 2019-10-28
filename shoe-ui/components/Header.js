import PropTypes from 'prop-types';
import {withStyles} from '@material-ui/core/styles';
import AppBar from "@material-ui/core/AppBar";
import Toolbar from "@material-ui/core/Toolbar";
import IconButton from "@material-ui/core/IconButton";
import React, {Component} from "react";
import Typography from "@material-ui/core/Typography";
import MenuIcon from '@material-ui/icons/Menu';
import Drawer from "@material-ui/core/Drawer";
import HomeIcon from '@material-ui/icons/Home';
import AddIcon from '@material-ui/icons/Add';
import InfoIcon from '@material-ui/icons/Info';
import CloudIcon from '@material-ui/icons/Cloud';
import LocalHospitalIcon from '@material-ui/icons/LocalHospital';
import Link from "next/link";
import List from "@material-ui/core/List";
import ListItem from "@material-ui/core/ListItem";
import ListItemText from "@material-ui/core/ListItemText";
import ListItemIcon from "@material-ui/core/ListItemIcon";
import {API_HOST_LOCAL} from "../config";

const styles = theme => ({
    root: {
        width: '100%',
        paddingBottom: 20
    },
    flex: {
        flex: 1,
    },
    menuButton: {
        marginLeft: -12,
        marginRight: 20,
    },
    drawerHeader: {
        display: 'flex',
        alignItems: 'center',
        justifyContent: 'flex-end',
        padding: '0 8px',
    },
    drawerPaper: {
        width: '200'
    },
    list: {
        width: 250,
    },
    fullList: {
        width: 'auto',
    }
});

class Header extends Component {

    constructor(props) {
        super(props);
    }

    state = {
        left: false,
    };

    toggleDrawer = (side, open) => () => {
        this.setState({
            [side]: open,
        });
    };

    render() {
        const {classes} = this.props;

        const sideList = (
            <div className={classes.list}>
                <List>
                    <ListItem button key='home'>
                        <ListItemIcon>{<HomeIcon/>}</ListItemIcon>
                        <Link href={'/'}><a><ListItemText primary='Home'/></a></Link>
                    </ListItem>
                    <ListItem button key='trueToSize'>
                        <ListItemIcon>{<AddIcon/>}</ListItemIcon>
                        <Link href={'/trueToSize'}><a><ListItemText primary='True to Size Fit'/></a></Link>
                    </ListItem>
                    <ListItem button key='api'>
                        <ListItemIcon>{<CloudIcon/>}</ListItemIcon>
                        <a href={API_HOST_LOCAL + '/swagger-ui.html'} target="_blank"><ListItemText primary='API'/></a>
                    </ListItem>
                    <ListItem button key='monitoring'>
                        <ListItemIcon>{<LocalHospitalIcon/>}</ListItemIcon>
                        <a href={API_HOST_LOCAL} target="_blank"><ListItemText primary='Monitoring'/></a>
                    </ListItem>
                    <ListItem button key='about'>
                        <ListItemIcon>{<InfoIcon/>}</ListItemIcon>
                        <Link href={'/about'}><a><ListItemText primary='About'/></a></Link>
                    </ListItem>
                </List>
            </div>
        );

        return (
            <div className={classes.root}>
                <AppBar position="static">
                    <Toolbar>
                        <IconButton onClick={this.toggleDrawer('left', true)} className={classes.menuButton}
                                    color="inherit" aria-label="Menu">
                            <MenuIcon/>
                        </IconButton>
                        <Typography variant="h5" color="inherit" className={classes.flex}>
                            Shoe Services
                        </Typography>
                    </Toolbar>
                </AppBar>

                <Drawer open={this.state.left} onClose={this.toggleDrawer('left', false)}>
                    <div
                        tabIndex={0}
                        role="button"
                        onClick={this.toggleDrawer('left', false)}
                        onKeyDown={this.toggleDrawer('left', false)}
                    >
                        {sideList}
                    </div>
                </Drawer>

            </div>
        );
    }
}

Header.propTypes = {
    classes: PropTypes.object.isRequired,
};

export default withStyles(styles)(Header);



